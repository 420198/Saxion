package week_4;

import java.util.Random;
import java.util.Scanner;

public class Opdracht7DieToss {
    public static void main(String[] args) {
        new Opdracht7DieToss().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int tosses;

        System.out.print("Amount of tosses: ");
        tosses = scanner.nextInt();

        //For blabla
        for (int i = 0; i < tosses; i++) {
            System.out.println("Roll "+i+": "+(random.nextInt(6)+1));
        }
    }
}
