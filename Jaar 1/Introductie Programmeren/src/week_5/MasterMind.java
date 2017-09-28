package week_5;

import java.util.Arrays;
import java.util.Scanner;

public class MasterMind {
    /**
     * PERFOMANCE BOOSTS
     * <p>
     * Created constants for a max num amount, this is as high as the number can be generated.
     * Created max places, this puts the number in a cache quicker and can be easier accessed than when .length is called
     * because the first time it still has to go over the entire length.
     * <p>
     * HAVE FUN YA ALL
     * ~Stijn Klarenbeek
     */

    private static final int MAX_NUM = 8;
    private static final int MAX_PLACES = 4;
    private static final int MAX_TURNS = 2;

    private int[] solution = new int[MAX_PLACES];
    private int[] mySol = new int[MAX_PLACES];
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new MasterMind().run();
    }

    public void run() {
        /*
         The rules of the game:
          - Computer picks 4 numbers out of [1, 8].
            For now, duplicates are NOT allowed.
          - while the combination has not been guessed and the number of turns has not been exceeded:
            - Player provides an (educated) guess
            - Computer provides feedback on the number of
              correctly placed items and the amount of numbers
              that are part of the solution but occur in thE wrong location
         */

        // Let the computer pick the solution...
        for (int i = 0; i < MAX_PLACES; i++) {
            // Pick a number between 1 and 8 (inclusive)
            boolean unique = false;

            int value = 0;
            while (!unique) {
                // Pick a value
                value = (int) (Math.random() * MAX_NUM + 1);

                // Assume the value is unique, unless proven otherwise...
                unique = true;
                for (int j = 0; j < i; j++) {
                    if (solution[j] == value) {
                        unique = false;
                    }
                }
            }
            solution[i] = value;
        }

        // We use Arrays.toString(...) to neatly print out the solution for us.
        System.out.println("[DEBUG] Solution: " + Arrays.toString(solution));

        System.out.println("Program created with " + MAX_TURNS + " turns. Please guess numbers between 1 and " + MAX_NUM);
        // Insert your code below..
        // While my turns dont exceed max turns
        for (int MY_TURNS = 0; MY_TURNS < MAX_TURNS; MY_TURNS++) {
            // New index
            int i = 0;
            //New strings, you can read what they mean
            String correctNumsCorrectPos = "Solution has the following nums in the correct position: ";
            String correctNumsWrongPos = "Solution has the following nums in the wrong postion: ";

            // Create solution
            while (i < MAX_PLACES) {
                System.out.print("Choose number: ");
                mySol[i] = scanner.nextInt();

                // why did you enter a number you cant use u twit, restart loop
                if (mySol[i] > MAX_NUM || mySol[i] <= 0) {
                    System.out.println("Chosen number exceeds boundaries!");
                    continue;
                }

                // Number in my solution is equal to the one in the solution
                if (mySol[i] == solution[i]) {
                    correctNumsCorrectPos += String.valueOf(mySol[i]) + "  ";
                } else if (hasNum(solution, mySol[i])) {
                    //Number aint correct but it is in the solution
                    correctNumsWrongPos += String.valueOf(mySol[i]) + "  ";
                }
                i++;
            }

            //if solution has been found, return so it will exit thie METHOD.
            if (solutionFound(mySol, solution)) {
                System.out.println("Congratz, you guessed it you twit!");
                return;
            }

            //print
            System.out.println(correctNumsCorrectPos);
            System.out.println(correctNumsWrongPos);

            // REINTIZILIZING IS IMPORTANT OTHERWISE THE NUMBERS IN ARRAY WONT BE RESET.
            mySol = new int[MAX_PLACES];
        }
        System.out.println("Too bad, you didnt guess it. Program stopping!");
    }

    /**
     * Check if an array has a num
     *
     * @param arr the array
     * @param num the num
     * @return true or false if num is in there
     */
    private boolean hasNum(int[] arr, int num) {
        for (int i : arr) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if a solution has been found, taking two arrays (mysolution and the ACTUAL solution). If one of the nums aint
     * correct, it will return false.
     * <p>
     * At the end of the loop, there was no return. This means all items are correct.
     *
     * @param mySol    mySolution array
     * @param solution the actual solution
     * @return already explained
     */
    private boolean solutionFound(int[] mySol, int[] solution) {
        for (int i = 0; i < MAX_PLACES; i++) {
            if (mySol[i] != solution[i]) {
                return false;
            }
        }
        return true;
    }
}