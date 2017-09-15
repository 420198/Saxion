import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import messages.Order;
import messages.OrderFailed;
import messages.OrderPassed;

import java.util.ArrayList;

/**
 * Created by sklar on 10/11/2016.
 */
public class Seller extends UntypedActor {
    private ArrayList<ActorRef> seatAgents;

    /**
     * Constructor, word aangeroepen via Props.create
     * @param seatAgents lijst met seat agents
     */
    private Seller(ArrayList<ActorRef> seatAgents) {
        assert !seatAgents.isEmpty() : "Er zijn geen vak agenten";
        this.seatAgents = seatAgents;
    }

    public static Props prop(ArrayList<ActorRef> seatAgents) {
        return Props.create(Seller.class, seatAgents);
    }

    @Override
    public void preStart() throws Exception {
        super.preStart();
    }

    /**
     * Onreceive, verzend messages op basis van datatype
     * @param o is het object
     * @throws Throwable
     */
    @Override
    public void onReceive(Object o) throws Throwable {
        assert o instanceof Order || o instanceof OrderFailed || o instanceof OrderPassed : "Iemand heeft een verkeerd object gemaakt";
        if (o instanceof Order) {
            seatAgents.get(((Order) o).getSeatType()).tell(o, getSelf());
        } else if (o instanceof OrderFailed) {
            ((OrderFailed) o).getUser().tell(o, getSelf());
        } else if (o instanceof OrderPassed) {
            ((OrderPassed) o).getUser().tell(o, getSelf());
        }
    }

    @Override
    public void postStop() throws Exception {
        super.postStop();
    }
}