package week_5;

import java.util.Arrays;
import java.util.Scanner;

public class Opdracht11 {
    public static void main(String[] args) {
        new Opdracht11().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements to add to the array: ");
        int[] arr = new int[scanner.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Please enter the value of the element at index "+i+": ");
            arr[i]=scanner.nextInt();
        }
        System.out.println("Input array: "+Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Sorted array: "+Arrays.toString(arr));
    }

    /**
     * Bubble sorteren.
     *
     * Voor bubblesort heb je een dubbele for loop. tis gwn switche van getallejtes wanneer dat moet
     * @param numbArray
     */
    private void bubbleSort(int[] numbArray) {
        int n = numbArray.length, temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (numbArray[j - 1] > numbArray[j]) {
                    temp = numbArray[j - 1];
                    numbArray[j - 1] = numbArray[j];
                    numbArray[j] = temp;
                }
            }
        }
    }
}
