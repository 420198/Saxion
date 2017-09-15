package messages;

import akka.actor.ActorRef;

/**
 * Created by sklar on 10/27/2016.
 */
public class OrderFailed {
    private ActorRef user;

    /**
     * constructor voor orderfailed
     *
     * @param user is verwijzing naar juiste actor
     */
    public OrderFailed(ActorRef user) {
        this.user = user;
    }

    /**
     * getter
     */
    public ActorRef getUser() {
        return user;
    }
}
