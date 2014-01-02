package de.prokaion.args.bean;

import java.util.HashMap;
import java.util.Map;

public class ArgContainer {
    
    private Map<String, Boolean> boolMap = new HashMap<>();
    
    public Boolean putBooleanArg(String key, Boolean value) {
        return boolMap.put(key, value);
    }
    
    public Boolean getBoolean(String key) {
        return boolMap.get(key);
    }
}
