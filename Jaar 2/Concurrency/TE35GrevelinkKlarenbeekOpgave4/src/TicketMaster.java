import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.ActorRefRoutee;
import akka.routing.Routee;
import akka.routing.Router;
import akka.routing.SmallestMailboxRoutingLogic;
import messages.Order;

import java.util.ArrayList;

/**
 * Created by sklar on 10/27/2016.
 */
public class TicketMaster extends UntypedActor {
    //router
    private Router router;

    //nieuwe arraylists
    private ArrayList<Routee> routees = new ArrayList<>();
    private ArrayList<ActorRef> agents = new ArrayList<>();

    public TicketMaster(int nrOfSellers) {
        //creer agenten en voeg ze toe aan lijst
        ActorRef agent = getContext().actorOf(AgentActor.prop(200, AgentKind.GENERAL_ADMISSION, 10), "a1");
        ActorRef agent1 = getContext().actorOf(AgentActor.prop(400, AgentKind.NORTH_GRANDSTAND, 10), "a2");
        ActorRef agent2 = getContext().actorOf(AgentActor.prop(400, AgentKind.SOUTH_GRANDSTAND, 10), "a3");
        ActorRef agent3 = getContext().actorOf(AgentActor.prop(1000, AgentKind.RESERVED_FLOOR_SEATING, 10), "a4");
        ActorRef agent4 = getContext().actorOf(AgentActor.prop(1600, AgentKind.STANDING_PIT, 10), "a5");
        agents.add(agent);
        agents.add(agent1);
        agents.add(agent2);
        agents.add(agent3);
        agents.add(agent4);

        //creer sales agents en voeg ze toe aan routees lijst
        for (int i = 0; i < nrOfSellers; i++) {
            routees.add(new ActorRefRoutee(getContext().actorOf(Seller.prop(agents), "s" + i)));
        }
        //instantieer router met smallestmailboxlogic en lijst met routees
        router = new Router(new SmallestMailboxRoutingLogic(), routees);

    }

    public static Props prop(int nrOfSellers) {
        return Props.create(TicketMaster.class, nrOfSellers);
    }

    @Override
    public void onReceive(Object o) throws Throwable {
        assert o instanceof Order : "Geen correcte datatype";
        router.route(o, getSelf());
        System.out.println(getSelf().toString() + " verzend order naar sales agent.");

    }
}
