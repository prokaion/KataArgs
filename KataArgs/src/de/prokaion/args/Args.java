package de.prokaion.args;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import de.prokaion.args.exception.FalseFlagException;
import de.prokaion.args.exception.UnKnownTypeException;

public class Args {
    
    private List<String> args;
    private String schema = null;
    private Map<Character, ArgMarshaller> argmarshallers = new HashMap<>();
    private Map<Character, String> argMap = new HashMap<>();
    
    public Args(String schema, String[] argsArray) {
        this.schema = schema;
        args = Arrays.asList(argsArray);
        parseSchema();
        parseArgs();
    }
    
    private void parseSchema() {
        String[] schemaValues = schema.split(",");
        for (String part : schemaValues) {
            String arg = part.substring(0, 1);
            String type = part.substring(1);
            createMarshaller(arg.charAt(0), type);
        }
    }
    
    private void createMarshaller(char arg, String type) {
        switch (type) {
            case "?":
                argmarshallers.put(arg, new BooleanMarshaller());
                break;
            
            default:
                throw new UnKnownTypeException("The schema can not interpret type of: " + arg + ". Type given was " + type);
        }
        
    }
    
    /**
     * 
     * @param args
     */
    private void parseArgs() {
        ListIterator<String> it = args.listIterator();
        while (it.hasNext()) {
            String current = it.next();
            if (current != null && isFlag(current)) { // must be a param
                char charAt = current.charAt(1);
                if (argmarshallers.get(charAt) == null) {
                    throw new FalseFlagException(current + " is an unknown to the schema!");
                } else {
                    // Check for a value for that flag
                    String value = getValueOrReturnDefault(it);
                    // Set value
                    argMap.put(charAt, value);
                    
                }
            }
        }
    }
    
    private String getValueOrReturnDefault(ListIterator<String> it) {
        String value = ""; // set default first
        
        if (it.hasNext()) {
            String next = it.next();
            if (!isFlag(next)) {
                value = next;
            } else { // reset it to previous
                it.previous();
            }
        }
        return value;
    }
    
    private boolean isFlag(String string) {
        return string.matches("-[a-z]");
    }
    
    public boolean getBoolean(char key) {
        // suche arg in argMap
        String argument = argMap.get(key);
        return (boolean) argmarshallers.get(key).marshal(argument);
    }
    
}
