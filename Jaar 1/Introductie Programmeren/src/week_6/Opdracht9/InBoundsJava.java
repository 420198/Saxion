package week_6.Opdracht9;

import java.util.Random;
import java.util.Scanner;

public class InBoundsJava {
    private Random random = new Random();
    private double LOWER_BOUND = random.nextDouble()*50;
    private double UPPER_BOUND= random.nextDouble()*50+LOWER_BOUND;
    public static void main(String[] args) {
        new InBoundsJava().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        double chosen;
        System.out.print("Input a number between "+LOWER_BOUND + " and " + UPPER_BOUND + ": ");

        do{
            chosen = scanner.nextDouble();
            if(inBounds(chosen)){
                break;
            }
            System.out.print("Incorrect, input another number: ");
        }while (!inBounds(chosen));
    }

    private boolean inBounds(double chosen) {
        return chosen >= LOWER_BOUND && chosen <= UPPER_BOUND;
    }
}
