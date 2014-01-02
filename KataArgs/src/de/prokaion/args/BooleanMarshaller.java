package de.prokaion.args;

public class BooleanMarshaller implements ArgMarshaller<Boolean> {
    
    @Override
    public Boolean marshal(String string) {
        if (string == null) { // arg was not given
            return false;
        }
        
        return string.isEmpty() ? Boolean.valueOf(true) : Boolean.parseBoolean(string);
    }
    
}
