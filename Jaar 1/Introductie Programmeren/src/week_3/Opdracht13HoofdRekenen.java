package week_3;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by thama on 20-9-2017.
 */
public class Opdracht13HoofdRekenen {
    public static void main(String[] args) {
        new Opdracht13HoofdRekenen().run();
    }

    private void run() {
        //Create vars
        Random r = new Random();
        Scanner s = new Scanner(System.in);
        int lowerBound, upperBound, numOne, numTwo, myAnswer;

        System.out.print("Enter lower bound: ");

        //Loopy
        do {
            //Read vars
            lowerBound = s.nextInt();
            System.out.print("Enter upper bound: ");
            upperBound = s.nextInt();

            //Determine nums
            numOne = r.nextInt(upperBound-lowerBound) + lowerBound;
            numTwo = r.nextInt(upperBound-lowerBound) + lowerBound;

            //Read answer
            System.out.print(String.valueOf(numOne) + " + " + String.valueOf(numTwo) + " = ");
            myAnswer = s.nextInt();

            //Checker
            if(myAnswer == (numOne+numTwo)){
                System.out.println("Correct!");
            }else{
                System.out.println("That is incorrect! The right answer was: " + String.valueOf((numOne+numTwo)));
            }

            System.out.print("\r\nEnter lower bound: ");
        } while (s.hasNextInt());
    }
}
