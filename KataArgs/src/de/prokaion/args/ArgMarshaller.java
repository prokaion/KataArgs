package de.prokaion.args;

public interface ArgMarshaller<T> {
    
    T marshal(String string);
    
}
