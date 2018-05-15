package by.bsuir.talakh.dao;

public class ClosingResourcesException extends RuntimeException {
    public ClosingResourcesException() {
        super();
    }

    public ClosingResourcesException(String message) {
        super(message);
    }

    public ClosingResourcesException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClosingResourcesException(Throwable cause) {
        super(cause);
    }
}
