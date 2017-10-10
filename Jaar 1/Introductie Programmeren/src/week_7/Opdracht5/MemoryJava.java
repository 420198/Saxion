package week_7.Opdracht5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MemoryJava {
    private int[] memoryPairs = {1, 1, 2, 2, 3, 3, 4, 4};
    private String[] answer = {".", ".", ".", ".", ".", ".", ".", "."};
    private int n1, n2;
    private Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        new MemoryJava().run();
    }

    private void run() {
        shuffle(memoryPairs);
        System.out.print("Please enter index 1: ");
        n1 = s.nextInt();
        System.out.print("Please enter index 2: ");
        n2 = s.nextInt();

        do {
            if (checkCorrect(n1, n2)) {
                System.out.println("Yeah! You found a pair");
                System.out.println(Arrays.toString(answer));
                if (finished()) break;
            } else {
                System.out.println("No, " + (n1) + " and " + (n2) + " is not a memory pair... (passive agressiveness intensifies)");
                answer[n1] = String.valueOf(memoryPairs[n1]);
                answer[n2] = String.valueOf(memoryPairs[n2]);
                System.out.println(Arrays.toString(answer));
                answer[n1] = answer[n2] = ".";
            }

            System.out.print("Please enter index 1: ");
            n1 = s.nextInt();
            System.out.print("Please enter index 2: ");
            n2 = s.nextInt();
        } while (!finished());
    }

    /**
     * Finished check
     *
     * @return finished
     */
    private boolean finished() {
        return !answer[0].equals(".") && !answer[1].equals(".") && !answer[2].equals(".") && !answer[3].equals(".") &&
                !answer[4].equals(".") && !answer[5].equals(".") && !answer[6].equals(".") && !answer[7].equals(".");
    }

    /**
     * Shuffling
     *
     * @param pairs array
     */
    private void shuffle(int[] pairs) {
        int index, temp;
        Random random = new Random();
        for (int i = pairs.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = pairs[index];
            pairs[index] = pairs[i];
            pairs[i] = temp;
        }
    }

    /**
     * Check if equals
     *
     * @param n1 number one
     * @param n2 number two
     * @return equals
     */
    private boolean checkCorrect(int n1, int n2) {
        if (memoryPairs[n1] == memoryPairs[n2]) {
            answer[n1] = answer[n2] = "(" + memoryPairs[n1] + ")";
            return true;
        }
        return false;
    }
}