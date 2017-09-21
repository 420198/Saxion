package week_4;

import java.util.Random;
import java.util.Scanner;

public class Opdracht8DiceToss {
    public static void main(String[] args) {
        new Opdracht8DiceToss().run();
    }

    private void run() {
        Random random = new Random();
        int ones = 0, twos = 0, threes = 0,
                fours = 0, fives = 0, sixes = 0,
                tossAmount, randNum;
        //Total number for average
        double  totalNum = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Amount of tosses? ");
        tossAmount = scanner.nextInt();

        //Simple loop
        for (int i = 0; i < tossAmount; i++) {
            randNum = random.nextInt(6) + 1;

            //Adds to the total number thrown so an average can be determined.
            totalNum+=randNum;
            if (randNum == 1) {
                ones++;
            } else if (randNum == 2) {
                twos++;
            } else if (randNum == 3) {
                threes++;
            } else if (randNum == 4) {
                fours++;
            } else if (randNum == 5) {
                fives++;
            } else if (randNum == 6) {
                sixes++;
            }
        }

        //Print
        System.out.println("Ones: " + ones);
        System.out.println("Twos: " + twos);
        System.out.println("Threes: " + threes);
        System.out.println("Fours: " + fours);
        System.out.println("Fives: " + fives);
        System.out.println("Sixe: " + sixes);
        System.out.println("\r\nAverage: "+String.valueOf((totalNum/tossAmount)));
    }
}
