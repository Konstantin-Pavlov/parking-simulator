package customExceptions;

public class IlligalCarStateException extends Exception {
    public IlligalCarStateException() {
    }

    public IlligalCarStateException(String message) {
        super(message);
    }
}
