package de.prokaion.args;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ArgsParser {
    
    private Map<String, String> paramMap = new HashMap<>();
    
    public void parse(String[] args) {
        
    }
    
    public Set<String> getKeys() {
        return paramMap.keySet();
        
    }
    
    public Object get(String key) {
        
        return paramMap.get(key);
    }
    
}
