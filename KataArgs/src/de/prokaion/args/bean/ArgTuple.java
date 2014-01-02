package de.prokaion.args.bean;

public class ArgTuple<T> {
    private String key;
    private T value;
    
    public ArgTuple(String key, T value) {
        super();
        this.key = key;
        this.value = value;
    }
    
    public String getKey() {
        return key;
    }
    
    public T getValue() {
        return value;
    }
}
