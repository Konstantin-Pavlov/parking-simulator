package customExceptions;

public class RecordNotPresentException extends Exception{
    public RecordNotPresentException() {
    }

    public RecordNotPresentException(String message) {
        super(message);
    }
}
