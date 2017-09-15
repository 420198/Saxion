package Model.Exceptions;

/**
 * Created by thama on 11-6-2017.
 */
public class DoesNotExistException extends RuntimeException {
    /**
     * Does not exist exception constructor
     *
     * @param message the message to be displayed
     */
    public DoesNotExistException(String message) {
        super(message);
    }
}
