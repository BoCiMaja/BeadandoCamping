package hu.uni.eku.tzs.service.exceptions;

public class CellaAlreadyExistsException extends Exception {
    public CellaAlreadyExistsException() {
    }

    public CellaAlreadyExistsException(String message) {
        super(message);
    }

    public CellaAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CellaAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public CellaAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
