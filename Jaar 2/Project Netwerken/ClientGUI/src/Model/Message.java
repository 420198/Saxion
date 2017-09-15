package Model;

/**
 * Created by sklar on 3/13/2017.
 */
public class Message {
    private String body;
    private String sender;

    /**
     * Message constructor
     *
     * @param sender de verzender
     * @param body  de body van de message
     */
    public Message(String sender, String body) {
        this.sender = sender;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public String getSender() {
        return sender;
    }
}
