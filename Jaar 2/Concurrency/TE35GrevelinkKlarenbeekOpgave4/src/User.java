import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import messages.Order;
import messages.OrderFailed;
import messages.OrderPassed;

import java.util.Random;

/**
 * Created by sklar on 10/11/2016.
 */
public class User extends UntypedActor {
    private Order order;
    private ActorRef master;
    private Random random = new Random();

    /**
     * user constructor, aangeroepen door props.create
     * @param money is hoeveelheid geld die user heeft
     * @param seatType is welke seatsoort hij wilt
     * @param ticketCount is hoeveelheid tickets die user wil
     * @param master is verwijzing naar master
     */
    private User(int money, int seatType, int ticketCount, ActorRef master) {
        assert money > 0 : "Geen geld";
        assert seatType < 5: "Incorrecte seat type";
        assert ticketCount > 0 : "Kan niet 0 tickets kopen";
        assert master != null : "Er is geen ticketmaster aangemaakt";
        order = new Order(ticketCount, seatType, money, getSelf());
        this.master = master;
    }

    public static Props prop(int money, int seatType, int ticketCount, ActorRef master) {
        return Props.create(User.class, money, seatType, ticketCount, master);
    }

    @Override
    public void preStart() throws Exception {
        super.preStart();
        master.tell(order, getSelf());
    }

    /**
     * Handel object af op basis van datatype.
     * @param o
     * @throws Throwable
     */
    @Override
    public void onReceive(Object o) throws Throwable {
        assert o instanceof OrderFailed || o instanceof OrderPassed : "Iemand heeft een verkeerd object gemaakt";
        if (o instanceof OrderPassed) {
            //order gelukt, stoppen
            System.out.println(toString() + " is blij dat hij een stoel heeft gekocht.");
            getContext().stop(getSelf());
        } else if (o instanceof OrderFailed) {
            //order niet gelukt, maak nieuwe
            newOrder();
            System.out.println(toString() + " plaatst nieuwe order");
        }
    }

    @Override
    public void postStop() throws Exception {
        super.postStop();
    }

    /**
     * maakt nieuwe order aan en geeft deze door aan master
     * @throws InterruptedException gooit exception door naar onreceive
     */
    private void newOrder() throws InterruptedException {
        Thread.sleep(random.nextInt(200));
        order = new Order(random.nextInt(5) + 1, random.nextInt(5), random.nextInt(5000), getSelf());
        master.tell(order, getSelf());
    }
}
