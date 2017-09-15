package Model.Exceptions;

/**
 * Created by thama on 11-6-2017.
 */
public class TooManyParamatersException extends RuntimeException {
    /**
     * Too many parameters exception constructor
     *
     * @param message the message to be displayed
     */
    public TooManyParamatersException(String message) {
        super(message);
    }
}