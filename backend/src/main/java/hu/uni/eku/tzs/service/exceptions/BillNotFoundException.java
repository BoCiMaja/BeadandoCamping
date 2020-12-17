package hu.uni.eku.tzs.service.exceptions;

public class BillNotFoundException extends Exception {
    public BillNotFoundException() {
    }

    public BillNotFoundException(String message) {
        super(message);
    }

    public BillNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BillNotFoundException(Throwable cause) {
        super(cause);
    }

    public BillNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
