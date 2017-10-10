package week_7.Opdracht4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MatchDotComJava {
    private int matchCount = 21;
    private static int PLAYER_ONE = 1, PLAYER_TWO = 2, CURR_PAYER = 2;

    private String message;
    private Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        new MatchDotComJava().run();
    }

    private void run() {
        do {
            nextPlayer();
            printMatches();
            takeMatches();
        } while (playing());
        System.out.println(message);
    }

    private void takeMatches() {
        System.out.print("\r\nPlayer " + CURR_PAYER + ", how many matches do you take (1, 2 or 3)? ");
        try{
            int num = s.nextInt();
            if(1 <= num && num <= 3){
                matchCount-=num;
            }else{
                takeMatches();
            }
        }catch (Exception e){
            System.out.println("You done fucked up!");
            System.exit(0);
        }
    }

    private void nextPlayer() {
        if (CURR_PAYER == PLAYER_ONE) {
            CURR_PAYER = PLAYER_TWO;
        } else {
            CURR_PAYER = PLAYER_ONE;
        }
        this.message = "\r\nPlayer " + CURR_PAYER + " has lost!!";
    }

    private void printMatches() {
        for (int i = 0; i < matchCount; i++) {
            System.out.print("|");
        }
        System.out.print(" (" + matchCount + ")");
    }

    private boolean playing() {
        return matchCount != 0;
    }
}
