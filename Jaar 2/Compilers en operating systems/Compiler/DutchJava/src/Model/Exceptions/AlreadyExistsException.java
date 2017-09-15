package Model.Exceptions;

/**
 * Created by thama on 10-6-2017.
 */
public class AlreadyExistsException extends RuntimeException {
    /**
     * Already exists exception constructor
     *
     * @param message the message to be displayed
     */
    public AlreadyExistsException(String message) {
        super(message);
    }
}
