package Model.Exceptions;

/**
 * Created by thama on 11-6-2017.
 */
public class DataTypesDontMatchException extends RuntimeException {
    /**
     * Datatypes dont match exception constructor
     *
     * @param message the message to be displayed
     */
    public DataTypesDontMatchException(String message) {
        super(message);
    }
}
