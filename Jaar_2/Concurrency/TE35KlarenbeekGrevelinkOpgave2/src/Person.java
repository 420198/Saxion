import java.util.Random;

/**
 * Created by sklar on 9/22/2016.
 */
public class Person extends Thread {
    private Random random;
    private String myid;

    /**
     * Constructor for person, has assertions to protect against unwanted ids
     *
     * @param myid String
     */
    public Person(String myid) {
        super();

        assert myid != null : " myid is null";
        assert !myid.isEmpty() : " myid is empty";

        random = new Random();
        this.myid = myid;
    }

    public void sleep(int ms) {
        try {
            Thread.sleep(random.nextInt(ms));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "<" + myid + ">";
    }
}
