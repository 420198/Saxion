import java.util.Random;

/**
 * Created by sklar on 12/2/2016.
 */
public class Permutation {
    private Random random;
    private int nrOfElements;
    private int[] permutation;
    private boolean[] usedNums;
    private int numCounter = 0;
    private int stepCounter = 0;
    private int permuteNum;

    /**
     * Permutation constructor
     *
     * @param permuteNum   num of permute
     * @param nrOfElements number of elements
     */
    public Permutation(int permuteNum, int nrOfElements) {
        this.permuteNum = permuteNum;
        this.nrOfElements = nrOfElements;
    }

    /**
     * Create the permutation
     */
    public long run() {
        random = new Random();
        permutation = new int[nrOfElements];
        usedNums = new boolean[nrOfElements];

        while (numCounter < nrOfElements) {
            stepCounter++;
            int num = random.nextInt(nrOfElements);
            if (!usedNums[num]) {
                usedNums[num] = true;
                permutation[numCounter] = num;
                numCounter++;
            }
        }

        System.out.println("Permutation " + permuteNum + ") Used: " + stepCounter + " steps");
        return stepCounter;
    }
}
