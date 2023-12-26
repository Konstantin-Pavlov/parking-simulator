package customExceptions;

public class CarNotPresentException extends Exception{
    public CarNotPresentException() {
        super();
    }

    public CarNotPresentException(String message) {
        super(message);
    }
}
