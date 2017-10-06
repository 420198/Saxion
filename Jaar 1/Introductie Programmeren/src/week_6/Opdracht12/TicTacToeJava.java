package week_6.Opdracht12;
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
    private String message;
    private Scanner scanner = new Scanner(System.in);

    private final static int PLAYER_ONE = 1;
    private final static int PLAYER_TWO = 2;
    private static int CURR_PAYER = 2;

    /**
     * While solution hasn't been found and board isn't full
     * ->Get the next player
     * ->Print board
     * ->Choose position the player wants
     */
    private void run() {
        do {
            nextPlayer();
            printBoard();
            choosePos();
        } while (!solutionFound() && !boardFull());

        printBoard();
        System.out.println(message);
    }

    /**
     * Choose ur position
     */
    private void choosePos() {
        System.out.print("\r\nPlayer " + CURR_PAYER + "'s move is: ");
        int pos = scanner.nextInt();
        if (pos < 1 || pos > 9) {
            System.out.println("This number is out of bounds");
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
        if (!objects[dimOne][dimTwo].equals(" ")) {
            System.out.println("Position already taken");
            choosePos();
        } else {
            if (CURR_PAYER == PLAYER_ONE) {
                objects[dimOne][dimTwo] = "X";
            } else {
                objects[dimOne][dimTwo] = "O";
            }
        }
    }

    /**
     * Sets the next player based on the current one
     */
    private void nextPlayer() {
        if (CURR_PAYER == PLAYER_ONE) {
            CURR_PAYER = PLAYER_TWO;
        } else {
            CURR_PAYER = PLAYER_ONE;
        }
        this.message = "\r\nPlayer "+CURR_PAYER+" has won!";
    }

    /**
     * If even one of these conditions is true then a solution was found
     * @return true or false based on one of these conditions
     */
    private boolean solutionFound() {
        if(objects[0][0].equals(objects[0][1]) && objects[0][0].equals(objects[0][2])) return !objects[0][0].equals(" ");
        else if(objects[1][0].equals(objects[1][1]) && objects[1][0].equals(objects[1][2])) return !objects[1][0].equals(" ");
        else if(objects[2][0].equals(objects[2][1]) && objects[2][0].equals(objects[2][2])) return !objects[2][0].equals(" ");
        else if(objects[0][0].equals(objects[1][0]) && objects[0][0].equals(objects[2][0])) return !objects[0][0].equals(" ");
        else if(objects[0][1].equals(objects[1][1]) && objects[0][1].equals(objects[2][1])) return !objects[0][1].equals(" ");
        else if(objects[0][2].equals(objects[1][2]) && objects[0][2].equals(objects[2][2])) return !objects[0][2].equals(" ");
        else if (objects[0][0].equals(objects[1][1]) && objects[0][0].equals(objects[2][2])) return !objects[0][0].equals(" ");
        else return objects[0][2].equals(objects[1][1]) && objects[0][2].equals(objects[2][0]) && !objects[0][2].equals(" ");
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
        this.message = "\r\nThis game is a draw!";
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
