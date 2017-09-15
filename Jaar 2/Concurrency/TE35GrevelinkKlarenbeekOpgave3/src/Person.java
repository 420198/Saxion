import java.util.Random;

/**
 * Created by sklar on 10/4/2016.
 */
public class Person extends Thread {
    protected Hiswa hiswa;
    private Random random;
    private int money;
    private String name;

    /**
     * Constructor for person
     *
     * @param name  String
     * @param hiswa Hiswa
     */
    public Person(String name, Hiswa hiswa) {
        assert !name.isEmpty() : "name is empty";
        assert name != null : "name is empty";
        assert hiswa != null : "hiswa is null";

        this.random = new Random();
        this.money = 1250000;
        this.name = name;
        this.hiswa = hiswa;
    }

    @Override
    public void run() {
        super.run();
    }

    /**
     * sleep method, used in justLive method and in the smulation for being inside the hiswa
     *
     * @param ms int
     */
    public void sleep(int ms) {
        assert ms > 0 : "can't sleep for 0 seconds";
        try {
            Thread.sleep(random.nextInt(ms));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes money from the persons
     *
     * @param amount int
     */
    public void removeMoney(int amount) {
        assert amount > 0 : "cant remove no money";
        this.money = this.money - amount;
    }

    /**
     * Just live method
     */
    protected void justLive() {
        sleep(2000);
    }

    @Override
    public String toString() {
        return "<" + name + "> -> ";
    }
}
