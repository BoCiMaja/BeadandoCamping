package hu.uni.eku.tzs.service.exceptions;

public class BillAlreadyExistsException extends Exception {
    public BillAlreadyExistsException() {
    }

    public BillAlreadyExistsException(String message) {
        super(message);
    }

    public BillAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BillAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public BillAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
