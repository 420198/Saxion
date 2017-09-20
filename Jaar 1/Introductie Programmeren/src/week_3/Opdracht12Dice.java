package week_3;

import java.util.Random;

/**
 * Created by thama on 20-9-2017.
 */
public class Opdracht12Dice {
    public static void main(String[] args) {
        new Opdracht12Dice().run();
    }

    private void run() {
        //Create random number
        int randNum = new Random().nextInt(6)+1;

        //Print
        System.out.println("You threw the die!");
        System.out.println("It landed on: " + String.valueOf(randNum));
    }
}
