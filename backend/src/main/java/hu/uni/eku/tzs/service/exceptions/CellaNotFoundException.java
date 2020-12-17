package hu.uni.eku.tzs.service.exceptions;

public class CellaNotFoundException extends Exception {
    public CellaNotFoundException() {
    }

    public CellaNotFoundException(String message) {
        super(message);
    }

    public CellaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CellaNotFoundException(Throwable cause) {
        super(cause);
    }

    public CellaNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}