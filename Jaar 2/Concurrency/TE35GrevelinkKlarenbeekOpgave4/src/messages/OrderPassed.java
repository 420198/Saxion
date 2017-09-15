package messages;

import akka.actor.ActorRef;

/**
 * Created by sklar on 10/27/2016.
 */
public class OrderPassed {

    private ActorRef user;

    /**
     * Constructor voor order passed,
     * @param user is de verwijzing naar correcte actor
     */
    public OrderPassed(ActorRef user) {
        this.user = user;
    }

    /**
     * getter
     */
    public ActorRef getUser() {
        return user;
    }

}
