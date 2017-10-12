import java.util.Scanner;

/**
 * Created by sklar on 11/17/2016.
 */
public class API {
    private Scanner scanner = new Scanner(System.in);
    private int choice = 0;
    private int loopAmount = 10;
    private int[] allowedNums;
    private long[] returnedPermutes;
    private void run() {
        //fill the allowed numbers array
        fillAllowedNums();
        returnedPermutes = new long[loopAmount];
        //show the options menu
        showMenu();
        //number validity
        do {
            System.out.println("Please enter a valid number");
            //check if it can be converted to an int
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter an actual number!");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (!contains(choice));
        //The switch for creating different permutations
        switch (choice) {
            case 1:
                startPermute(5000);
                break;
            case 2:
                startPermute(10000);
                break;
            case 3:
                startPermute(20000);
                break;
            case 4:
                startPermute(50000);
                break;
            case 5:
                startPermute(100000);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("\nYnou haven't entered a valid number!");
                run();
                break;
        }

    }

    /**
     * Create loopAmount permutations (in our case 10)
     *
     * @param numElements int
     */
    private void startPermute(int numElements) {
        System.out.println("\nWe will run the permutation creator " + loopAmount + " times with " + numElements + " elements.\n");
        for (int i = 0; i < loopAmount; i++) {
            //start the permutation
            returnedPermutes[i]=new Permutation(i+1, numElements).run();
        }
        //Call the run method again
        System.out.println("\nAverage: "+determineAverage()+"\n");
        run();
    }

    /**
     * Method to check if a number is in the allowednums list
     *
     * @param num int
     * @return true or false based on wether it's allowed
     */
    private boolean contains(int num) {
        for (int i = 0; i < allowedNums.length; i++) {
            if (allowedNums[i] == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determine the average of all nums
     * @return average
     */
    private long determineAverage(){
        long average = 0;
        for (int i = 0; i < returnedPermutes.length; i++) {
            average += returnedPermutes[i];
        }
        return average/loopAmount;
    }
    /**
     * Method to fill the array with numbers
     */
    private void fillAllowedNums() {
        allowedNums = new int[6];
        allowedNums[0] = 1;
        allowedNums[1] = 2;
        allowedNums[2] = 3;
        allowedNums[3] = 4;
        allowedNums[4] = 5;
        allowedNums[5] = 0;
    }

    /**
     * Method to show the menu
     */
    private void showMenu() {
        System.out.println(" __________________________________________\n" +
                "| Welcome to the permutation creator       |\n" +
                "|                                          |\n" +
                "| please choose permutation amount         |\n" +
                "|------------------------------------------|\n" +
                "| 1.   5.000                               |\n" +
                "| 2.  10.000                               |\n" +
                "| 3.  20.000                               |\n" +
                "| 4.  50.000                               |\n" +
                "| 5. 100.000                               |\n" +
                "|                                          |\n" +
                "| 0. exit permutation creator              |\n" +
                "|__________________________________________|");
    }

    public static void main(String args[]) {
        new API().run();
    }
}