package Model.Exceptions;

/**
 * Created by thama on 11-6-2017.
 */
public class MissingParamatersException extends RuntimeException {
    /**
     * Missing parameters constructor
     *
     * @param message the message to be displayed
     */
    public MissingParamatersException(String message) {
        super(message);
    }
}
