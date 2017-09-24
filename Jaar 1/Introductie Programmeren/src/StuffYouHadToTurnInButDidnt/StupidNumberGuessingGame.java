package StuffYouHadToTurnInButDidnt;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by thama on 24-9-2017.
 */
public class StupidNumberGuessingGame {
    public static void main(String[] args) {
        new StupidNumberGuessingGame().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        int answer = random.nextInt(10) + 1,
                myAnswer = 0;

        System.out.println("Welcome to the worst number guessing game ever made!");
        System.out.print("Input a number you twit: ");
        do {
            myAnswer = scanner.nextInt();
            if(myAnswer==answer){
                break;
            }else if(myAnswer < answer){
                System.out.println("You guessed too low!");
            }else{
                System.out.println("You guessed too high! ");
            }
            System.out.print("Input a number you twit: ");
        } while (scanner.hasNextInt());
        System.out.println("Congratz u twit, u guessed it! Or u decided to input a wrong number or a letter");
    }
}
