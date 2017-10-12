/**
 * Created by sklar on 10/5/2016.
 */
public class World {
    public static final int NR_VISITORS = 14;
    private static final int NR_BUYERS = 4;

    public static void main(String args[]) {
        Hiswa hiswa = new Hiswa();

        //Create 2 thread arrays
        Thread[] buyers = new Thread[NR_BUYERS];
        Thread[] visitors = new Thread[NR_VISITORS];

        //start all the visitors
        for (int i = 0; i < NR_VISITORS; i++) {
            visitors[i] = new Visitor("v" + i, hiswa);
            visitors[i].start();
        }

        //start all the buyers
        for (int i = 0; i < NR_BUYERS; i++) {
            buyers[i] = new Buyer("b" + i, hiswa);
            buyers[i].start();
        }
    }
}
