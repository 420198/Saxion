import java.util.Random;

/**
 * Created by sklar on 12/8/2016.
 */
public class Permutation {
    private Random random;
    private int nrOfElements;
    private int[] permutation;
    private int numCounter = 0;
    private long stepCounter = 0;
    private int permuteNum;

    /**
     * Permutation constructor
     *
     * @param permuteNum   number of permute
     * @param nrOfElements number of elements
     */
    public Permutation(int permuteNum, int nrOfElements) {
        this.permuteNum = permuteNum;
        this.nrOfElements = nrOfElements;
    }

    /**
     * Create the permutation
     *
     * @return the amount of steps needed
     */
    public long run() {
        random = new Random();
        permutation = new int[nrOfElements];

        while (numCounter < nrOfElements) {
            int num = random.nextInt(nrOfElements);
            stepCounter++;
            if (!contains(num)) {
                permutation[numCounter] = num;
                numCounter++;
            }
        }
        System.out.println("Permutation " + permuteNum + ") Used: " + stepCounter + " steps");
        return stepCounter;
    }

    /**
     * Check if number already exists within the list
     *
     * @param j the new number
     * @return true or false based on wether or not it exists
     */
    private boolean contains(int j) {
        for (int i = 0; i < numCounter; i++) {
            stepCounter++;
            if (permutation[i] == j) {
                return true;
            }
        }
        return false;
    }

}
