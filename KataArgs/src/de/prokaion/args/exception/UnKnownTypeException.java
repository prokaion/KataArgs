package de.prokaion.args.exception;

public class UnKnownTypeException extends RuntimeException {
    
    private static final long serialVersionUID = -1106783381131021783L;
    
    public UnKnownTypeException() {
    }
    
    public UnKnownTypeException(String message) {
        super(message);
        
    }
    
    public UnKnownTypeException(Throwable cause) {
        super(cause);
        
    }
    
    public UnKnownTypeException(String message, Throwable cause) {
        super(message, cause);
        
    }
    
    public UnKnownTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        
    }
    
}
