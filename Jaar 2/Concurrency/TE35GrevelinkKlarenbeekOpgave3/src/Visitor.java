/**
 * Created by sklar on 10/4/2016.
 */
public class Visitor extends Person {

    public Visitor(String name, Hiswa hiswa) {
        super(name, hiswa);
    }

    @Override
    public void run() {
        while (true) {
            //Enter hiswa
            hiswa.enter(this);

            //check out the cool boats
            checkOutHiswa();

            //must part ways with the hiswa
            hiswa.leave(this);

            //keep on living, sad that you aren't at the hiswa no more
            justLive();
        }
    }

    /**
     * Simulation for going into the hiswa and checking out the boats
     */
    private void checkOutHiswa() {
        //Go in
        System.out.println(this.toString() + " gaat naar binnen");

        //Remove money
        this.removeMoney(10);
        sleep(2000);
        System.out.println(this.toString() + " gaat weg");
    }
}
