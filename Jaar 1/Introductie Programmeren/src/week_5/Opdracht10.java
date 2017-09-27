package week_5;

import java.util.Arrays;
import java.util.Random;

public class Opdracht10 {
    private Random random = new Random();

    public static void main(String[] args) {
        new Opdracht10().run();
    }

    private void run() {
        int[] firstArray = new int[7];
        firstArray[0] = 0;
        firstArray[1] = 2;
        firstArray[2] = 5;
        firstArray[3] = 7;
        firstArray[4] = 10;
        firstArray[5] = 12;
        firstArray[6] = 14;

        int[] secondArray = new int[3];
        secondArray[0] = 3;
        secondArray[1] = 7;
        secondArray[2] = 11;

        int[] merged = merge(firstArray, secondArray);

        for (int i = 0; i < merged.length; i++) {
            System.out.println(merged[i]);
        }

    }

    /**
     * Merge arrays
     * @param firstArray, first array
     * @param secondArray secomd array
     * @return merged array
     */
    private int[] merge(int[] firstArray, int[] secondArray) {
        int[] merge = new int[firstArray.length + secondArray.length];
        int h = 0, i = 0, j = 0;

        while (i < firstArray.length && j < secondArray.length) {
            /*
            Quick way to do the if. After the question mark is the if, after the : is the else
            */
            merge[h++] = firstArray[i] < secondArray[j] ? firstArray[i++] : secondArray[j++];
        }
        //Either 1 or the other is now higher than the length. Fill thhe last up
        while (i < firstArray.length) {
            merge[h++] = firstArray[i++];
        }

        while (j < secondArray.length) {
            merge[h++] = secondArray[j++];
        }

        return merge;
    }


}
