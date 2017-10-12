import java.util.Random;
import java.util.Scanner;

/**
 * Created by sklar on 12/1/2016.
 */
public class API {
    public static void main(String args[]) {
        new API().run();
    }

    private int numElements = 0;
    private int heapsize = 0;
    private Scanner scanner = new Scanner(System.in);
    private int loopAmount = 10;
    private int[] allowedNums;

    private void run() {
        //fill the allowed numbers array
        fillAllowedNums();

        //show the heapsize menu
        showHeapSizeOptions();
        heapsize = runScan();

        //show the number options menu
        showNumberOptions();
        numElements = runScan();

        //The switch for creating different heapsizes
        switch (heapsize) {
            case 1:
                heapsize = 6;
                break;
            case 2:
                heapsize = 7;
                break;
            case 3:
                heapsize = 8;
                break;
            case 4:
                heapsize = 9;
                break;
            case 5:
                heapsize = 10;
                break;
            case 6:
                heapsize = 11;
                break;
            case 0:
                System.exit(0);
                break;
        }

        //the switch for setting different number elements
        switch (numElements) {
            case 1:
                numElements = 20000;
                break;
            case 2:
                numElements = 30000;
                break;
            case 3:
                numElements = 40000;
                break;
            case 4:
                numElements = 50000;
                break;
            case 5:
                numElements = 60000;
                break;
            case 6:
                numElements = 70000;
                break;
            case 0:
                System.exit(0);
                break;
        }
        createHeap(heapsize, numElements);
    }

    /**
     * Create loopAmount heap simulations (in our case 10)
     *
     * @param numElements int
     */
    private void createHeap(int heapsize, int numElements) {
        for (int i = 0; i < loopAmount; i++) {
            //start the heap
            heapsize *= 2;
            startHeap(heapsize, numElements);
        }
        run();
    }

    /**
     * Method to check if a number is in the allowednums list
     *
     * @param num int
     * @return true or false based on wether it's allowed
     */
    private boolean contains(int num) {
        System.out.println("Starting the run creator!");
        for (int i = 0; i < allowedNums.length; i++) {
            if (allowedNums[i] == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * Create array with num elements and start making runs using the rsheap.
     *
     * @param heapsize
     * @param numElements
     */
    private void startHeap(int heapsize, int numElements) {
        SimulatedFile in = new SimulatedFile();
        SimulatedFile out = new SimulatedFile();
        StringBuilder builder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < numElements; i++) {
            builder.append(random.nextInt(100000) + ",");
        }
        in.setFile(builder.toString());
        RsHeap rsHeap = new RsHeap(in, out, heapsize);
        rsHeap.run();
    }

    /**
     * Method to fill the array with numbers
     */
    private void fillAllowedNums() {
        allowedNums = new int[7];
        allowedNums[0] = 1;
        allowedNums[1] = 2;
        allowedNums[2] = 3;
        allowedNums[3] = 4;
        allowedNums[4] = 5;
        allowedNums[5] = 6;
        allowedNums[6] = 0;
    }

    /**
     * Method for reading the input by making sure it is an allowed number and that it isnt a letter.
     *
     * @return the chosen number
     */
    private int runScan() {
        int choice = 0;
        do {
            System.out.println("Please enter a valid number");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter an actual number!");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (!contains(choice));
        return choice;
    }

    /**
     * Method to show the heapsize menu
     */
    private void showHeapSizeOptions() {
        System.out.println(" __________________________________________\n" +
                "| Welcome to the heap runs creator!        |\n" +
                "|                                          |\n" +
                "| Choose your starting heapsize!           |\n" +
                "| Heapsize will increase each round by 2.  |\n" +
                "|------------------------------------------|\n" +
                "| 1. Heapsize 6                            |\n" +
                "| 2. Heapsize 7                            |\n" +
                "| 3. Heapsize 8                            |\n" +
                "| 4. Heapsize 9                            |\n" +
                "| 5. Heapsize 10                           |\n" +
                "| 6. Heapsize 11                           |\n" +
                "|                                          |\n" +
                "| 0. exit heap creator                     |\n" +
                "|__________________________________________|");
    }

    /**
     * Method to show the amount of elements menu
     */
    private void showNumberOptions() {
        System.out.println(" __________________________________________\n" +
                "| Welcome to the heap runs creator!        |\n" +
                "|                                          |\n" +
                "| Choose the number of elements!           |\n" +
                "|------------------------------------------|\n" +
                "| 1.  20.000                               |\n" +
                "| 2.  30.000                               |\n" +
                "| 3.  40.000                               |\n" +
                "| 4.  50.000                               |\n" +
                "| 5.  60.000                               |\n" +
                "| 6.  70.000                               |\n" +
                "|                                          |\n" +
                "| 0. exit heap creator                     |\n" +
                "|__________________________________________|");
    }
}
