import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by sklar on 11/17/2016.
 */
public class Api {
    private Scanner scanner = new Scanner(System.in);
    private int choice = 0;
    private int[] allowedNums;

    private static BoardLoader boardLoader;
    private static File file;

    private void run() {
        fillAllowedNums();

        showMenu();

        do {
            System.out.println("Please enter a valid number");
            //check if it can be converted to an int
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter an actual number!");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (!contains(choice));

        //The switch for creating different game settings
        switch (choice) {
            case 1:
                playGame((byte)1,(byte)2,(byte)23);
                break;
            case 2:
                playGame((byte)2,(byte)1,(byte)23);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("\nYnou haven't entered a valid number!");
                run();
                break;
        }
    }

    private void playGame(byte posOne, byte posTwo, byte endPos) {
        Game game = new Game(posOne,posTwo,endPos,boardLoader);
        game.play();
        run();
    }

    /**
     * Method to check if a number is in the allowednums list
     *
     * @param num int
     * @return true or false based on wether it's allowed
     */
    private boolean contains(int num) {
        for (int i = 0; i < allowedNums.length; i++) {
            if (allowedNums[i] == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to fill the array with numbers
     */
    private void fillAllowedNums() {
        allowedNums = new int[3];
        allowedNums[0] = 1;
        allowedNums[1] = 2;
        allowedNums[2] = 0;
    }

    /**
     * Method to show the menu
     */
    private void showMenu() {
        System.out.println(" __________________________________________\n" +
                "|                                          |\n" +
                "| Welcome to the best playboard ever       |\n" +
                "|                                          |\n" +
                "|------------------------------------------|\n" +
                "| 1. Starts with pion 1 at position 1      |\n" +
                "| 2. Starts with pion 2 at position 1      |\n" +
                "|                                          |\n" +
                "| 0. exit game                             |\n" +
                "|__________________________________________|");
    }

    public static void main(String args[]) {
        file = new File("board");
        try {
            boardLoader = new BoardLoader(file);
            boardLoader.loadBoard();
            new Api().run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}