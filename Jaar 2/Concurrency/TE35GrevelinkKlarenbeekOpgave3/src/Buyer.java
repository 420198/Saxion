/**
 * Created by sklar on 10/5/2016.
 */
public class Buyer extends Person {
    /**
     * Constructor for buyer
     *
     * @param name  String
     * @param hiswa Hiswa
     */
    public Buyer(String name, Hiswa hiswa) {
        super(name, hiswa);
    }

    @Override
    public void run() {
        while (true) {
            //enter the hiswa
            hiswa.enter(this);

            //buy dat boat
            buyBoat();

            //leave hiswa
            hiswa.leave(this);

            //live with your new boat
            justLive();
        }
    }

    /**
     * Simulation for going into the hiswa
     */
    private void buyBoat() {
        //Go inside
        System.out.println(this.toString() + " gaat naar binnen");

        //remove the money
        this.removeMoney(250000);

        sleep(2000);
        System.out.println(this.toString() + " gaat weg");

    }
}
