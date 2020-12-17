package hu.uni.eku.tzs.service.exceptions;

public class FoglalasNotFoundException extends Exception {
    public FoglalasNotFoundException() {
    }

    public FoglalasNotFoundException(String message) {
        super(message);
    }

    public FoglalasNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FoglalasNotFoundException(Throwable cause) {
        super(cause);
    }

    public FoglalasNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
