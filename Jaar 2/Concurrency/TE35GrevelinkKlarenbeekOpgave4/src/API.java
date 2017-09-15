import akka.actor.ActorRef;
import akka.actor.ActorSystem;

import java.util.Random;

/**
 * Created by sklar on 10/11/2016.
 */
public class API {

    private int nrOfCustomers = 25;
    private ActorRef user;
    private Random random = new Random();

    public static void main(String args[]) {
        new API().run();
    }

    private void run() {
        //nieuwe actorsysteem en ticket master
        ActorSystem system = ActorSystem.create("DesertTrip");
        ActorRef master = system.actorOf(TicketMaster.prop(1200));

        //loop door customer aantal en maak er zoveel aan
        while (nrOfCustomers > 0) {
            user = system.actorOf(User.prop(random.nextInt(2000),random.nextInt(5),random.nextInt(3)+1, master));
            nrOfCustomers--;
        }

        //lange sleep voor terminate
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            system.terminate();
        }
    }
}
