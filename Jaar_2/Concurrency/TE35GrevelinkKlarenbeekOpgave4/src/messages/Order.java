package messages;

import akka.actor.ActorRef;

/**
 * Created by sklar on 10/12/2016.
 */
public class Order {
    private int ticketCount;
    private int seatType;
    private ActorRef user;
    private int userMoney;

    /**
     * Order constructor
     * @param ticketCount hoeveelheid tickets
     * @param seatType is seat type
     * @param userMoney hoeveel geld user heeft
     * @param user is user
     */
    public Order(int ticketCount, int seatType, int userMoney, ActorRef user) {
        this.ticketCount = ticketCount;
        this.seatType = seatType;
        this.userMoney = userMoney;
        this.user = user;
    }

    /**
     * Getters
     */
    public int getTicketCount() {
        return ticketCount;
    }

    public int getSeatType() {
        return seatType;
    }

    public ActorRef getUser() {
        return user;
    }

    public int getUserMoney() {
        return userMoney;
    }
}
