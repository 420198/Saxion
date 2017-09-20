package week_3;

/**
 * Created by thama on 20-9-2017.
 */
public class Opdracht10 {
    //2D array
    private String[][] objects = new String[][]{
            {"2", "X", "2"},
            {"O", "-", "1"},
            {"X", "7", "2"}
    };

    public static void main(String[] args) {
        new Opdracht10().run();
    }

    private void run() {
        printBoard();
    }

    /**
     * Print het bord
     */
    private void printBoard() {
        //Eerste dimensie
        for (int i = 0; i < objects.length; i++) {
            //print die domme streepjes I groter is dan 0
            if (i > 0) {
                System.out.println("\r\n---------");
            }
            //tweede dimensie
            for (int j = 0; j < objects[i].length; j++) {
                //print element uit op positie
                System.out.print(objects[i][j]);
                //Print tussen streep
                if (j < objects[i].length - 1) {
                    System.out.print(" | ");
                }
            }
        }
    }
}
