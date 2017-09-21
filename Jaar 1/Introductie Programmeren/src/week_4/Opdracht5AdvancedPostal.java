package week_4;

import java.util.Scanner;

public class Opdracht5AdvancedPostal {
    public static void main(String[] args) {
        new Opdracht5AdvancedPostal().run();
    }

    private void run() {
        //Scanner
        Scanner scanner = new Scanner(System.in);

        //Create var
        int postal, lowerBound, upperBound;

        System.out.print("Input lower bound: ");
        do {
            //Read bounds
            lowerBound = scanner.nextInt();
            System.out.print("Input upper bound: ");
            upperBound = scanner.nextInt();

            if (lowerBound > upperBound) {
                System.out.println("The lower bound exceeds the upper bound.");
                System.out.print("Input lower bound: ");
                //Continue restarts the loop (goes to NEXT iteration in for loops)
                continue;
            } else if (lowerBound == upperBound) {
                System.out.println("The lower bound is equal to the upper bound.");
                System.out.print("Input lower bound: ");
                continue;
            } else {
                System.out.print("Input a value between " + lowerBound + " and " + upperBound + ": ");
                do {
                    //Read in num
                    postal = scanner.nextInt();
                    //Checker
                    if (postal >= lowerBound && postal <= upperBound) {
                        System.out.println("Postal code accepted!");

                        //Break out the loop if correct
                        break;
                    } else if (postal < lowerBound) {
                        System.out.println("Invalid postal code (too low)! Try again.");
                    } else {
                        System.out.println("Invalid postal code (too high)! Try again.");
                    }
                    System.out.print("Input a value between " + lowerBound + " and " + upperBound + ": ");
                } while (scanner.hasNextInt());
                break;
            }
        } while (scanner.hasNextInt());
    }
}
