import akka.actor.Props;
import akka.actor.UntypedActor;
import messages.Order;
import messages.OrderFailed;
import messages.OrderPassed;

/**
 * Created by sklar on 10/11/2016.
 */
public class AgentActor extends UntypedActor {
    private int price = 0;
    private AgentKind agentKind;
    private int tickAmount;

    /**
     * agentactor constructor, aangeroepen door props.create
     * @param price is hoe duur de kaartjes van het vak zijn
     * @param agentKind is agentsoort
     * @param tickAmount is hoeveel tickets hij kan verkopen
     */
    private AgentActor(int price, AgentKind agentKind, int tickAmount) {
        assert price > 0 : "kaartjes worden niet gratis weggegeven";
        assert agentKind != null : "Agent soort is null";
        assert tickAmount > 0 : "Vak heeft altijd meer dan 0 plekken";
        this.price = price;
        this.agentKind = agentKind;
        this.tickAmount = tickAmount;
    }

    public static Props prop(int price, AgentKind agentKind, int tickAmount) {
        return Props.create(AgentActor.class, price, agentKind, tickAmount);
    }

    @Override
    public void preStart() throws Exception {
        super.preStart();
    }


    /**
     * Krijgt order binnen en verwerkt deze
     * @param o is de order
     * @throws Throwable
     */
    @Override
    public void onReceive(Object o) throws Throwable {
        assert o instanceof Order : "Object geen instance van order";
        //check om te kijken of agent nog genoeg ticks heeft
        if (tickAmount > 0 && tickAmount >= ((Order) o).getTicketCount()) {
            //heeft genoeg ticks dus creeer kaart prijs
            int price = ((Order) o).getTicketCount() * this.price;
            //check voor geld
            if (((Order) o).getUserMoney() >= price) {
                //genoeg geld, tick amount geminderd en nieuw orderpassed object
                tickAmount -= ((Order) o).getTicketCount();
                System.out.println(((Order) o).getUser().toString() + " heeft " + ((Order) o).getTicketCount() + " stoelen gekocht voor vak " + agentKind);
                getSender().tell(new OrderPassed(((Order) o).getUser()), getSelf());
            } else {
                //te arm, nieuwe orderfailed object
                System.out.println(((Order) o).getUser().toString() + " heeft niet genoeg geld en kan geen stoel kopen");
                getSender().tell(new OrderFailed(((Order) o).getUser()), getSelf());
            }
        } else {
            //niet genoeg kaarten, nieuw orderfailed object
            getSender().tell(new OrderFailed(((Order) o).getUser()), getSelf());
        }

    }

    @Override
    public void postStop() throws Exception {
        super.postStop();
    }
}