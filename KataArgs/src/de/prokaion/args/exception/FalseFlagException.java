package de.prokaion.args.exception;

public class FalseFlagException extends RuntimeException {
    
    private static final long serialVersionUID = -6251123861968659188L;
    
    public FalseFlagException() {
    }
    
    public FalseFlagException(String message) {
        super(message);
    }
    
    public FalseFlagException(Throwable cause) {
        super(cause);
    }
    
    public FalseFlagException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public FalseFlagException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
