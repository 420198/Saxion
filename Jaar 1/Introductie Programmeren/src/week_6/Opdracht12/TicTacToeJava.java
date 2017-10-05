package week_6.Opdracht12;
//

// NOT WORKING, WILL FIX AT HOME


import java.util.Scanner;

public class TicTacToeJava {
    public static void main(String[] args) {
        new TicTacToeJava().run();
    }

    //2D array
    private String[][] objects = new String[][]{
            {" ", " ", " "},
            {" ", " ", " "},
            {" ", " ", " "}
    };
    private Scanner scanner = new Scanner(System.in);

    private final static int PLAYER_ONE = 1;
    private final static int PLAYER_TWO = 2;
    private static int CURR_PAYER = 2;

    private void run() {
        do {
            nextPlayer();
            printBoard();
            choosePos();
        } while (!boardFull() && !solutionFound());
    }

    private void choosePos() {
        System.out.println("\r\n Player " + CURR_PAYER + "'s move is");
        int pos = scanner.nextInt();
        if (pos < 1 && pos > 9) {
            choosePos();
        } else {
            pos--;
            if (pos <= 2) {
                setPos(0, pos);
            } else if (pos > 2 && pos <= 5) {
                setPos(1, pos % 3);
            } else {
                setPos(2, pos % 3);
            }
        }
    }

    /**
     * Set X or O at dimension two of dimension one
     *
     * @param dimOne dimension one
     * @param dimTwo dimension two
     */
    private void setPos(int dimOne, int dimTwo) {
        if (playerOneActive()) {
            objects[dimOne][dimTwo] = "X";
        } else {
            objects[dimOne][dimTwo] = "O";
        }
    }

    private void nextPlayer() {
        if (CURR_PAYER == PLAYER_ONE) {
            CURR_PAYER = PLAYER_TWO;
        } else {
            CURR_PAYER = PLAYER_ONE;
        }
    }

    private boolean playerOneActive() {
        return CURR_PAYER == PLAYER_ONE;
    }


    private boolean solutionFound() {
        if(objects[0][0].equals(objects[0][1]) && objects[0][0].equals(objects[0][2])) return !objects[0][0].equals(" ");
        else if(objects[1][0].equals(objects[1][1]) && objects[1][0].equals(objects[1][2])) return !objects[0][0].equals(" ");
        else if(objects[2][0].equals(objects[2][1]) && objects[2][0].equals(objects[2][2])) return !objects[0][0].equals(" ");
        else if(objects[0][0].equals(objects[1][0]) && objects[0][0].equals(objects[2][0])) return !objects[0][0].equals(" ");
        else if(objects[0][1].equals(objects[1][1]) && objects[0][1].equals(objects[2][1])) return !objects[0][0].equals(" ");
        else if(objects[0][2].equals(objects[1][2]) && objects[0][1].equals(objects[2][2])) return !objects[0][0].equals(" ");
        else if(objects[0][0].equals(objects[1][1]) && objects[0][0].equals(objects[2][2])) return !objects[0][0].equals(" ");
        else if(objects[0][2].equals(objects[1][1]) && objects[0][2].equals(objects[2][0])) return !objects[0][0].equals(" ");
        return false;
    }

    /**
     * Check if borard is full
     * @return
     */
    private boolean boardFull() {
        for (String[] object : objects) {
            for (String anObject : object) {
                if (anObject.equals(" ")) return false;
            }
        }
        return true;
    }


    /**
     * Print het bord
     */
    private void printBoard() {
        for (int i = 0; i < objects.length; i++) {
            if (i > 0) {
                System.out.println("\r\n---------");
            }
            for (int j = 0; j < objects[i].length; j++) {
                System.out.print(objects[i][j]);
                if (j < objects[i].length - 1) {
                    System.out.print(" | ");
                }
            }
        }
    }
}
