package Model.Exceptions;

/**
 * Created by thama on 12-6-2017.
 */
public class InvalidReturnTypeException extends RuntimeException {
    /**
     * Invalid return type exception constructor
     *
     * @param message the message to be displayed
     */
    public InvalidReturnTypeException(String message) {
        super(message);
    }
}
