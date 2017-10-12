import java.util.Random;

/**
 * Created by sklar on 12/1/2016.
 */
public class Permutation {
    private Random random;
    private int[] numbers;
    private int nrOfElements;
    private int stepCounter = 0;
    private int randPlace;
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
        numbers = new int[nrOfElements];
        random = new Random();
        for (int i = 1; i < numbers.length; i++) {
            stepCounter++;
            randPlace = random.nextInt(i + 1);
            numbers[i] = i;

            int temp = numbers[randPlace];
            numbers[randPlace] = i;
            numbers[i] = temp;
        }
        System.out.println("Permutation " + permuteNum + ") Used: " + stepCounter + " steps");
        return stepCounter;
    }
}
