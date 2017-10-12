package Model.Exceptions;

/**
 * Created by thama on 10-6-2017.
 */
public class InvalidTypeException extends RuntimeException {
    /**
     * Invalid type exception constructor
     *
     * @param message the message to be displayed
     */
    public InvalidTypeException(String message) {
        super(message);
    }
}
