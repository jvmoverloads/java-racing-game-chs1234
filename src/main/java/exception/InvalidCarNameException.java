package exception;

public class InvalidCarNameException extends RacingGameException {
    public InvalidCarNameException(String message) {
        super(message);
    }
}
