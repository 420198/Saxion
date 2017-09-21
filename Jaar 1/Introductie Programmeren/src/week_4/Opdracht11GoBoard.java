package week_4;

import java.util.Scanner;

public class Opdracht11GoBoard {
    public static void main(String[] args) {
        new Opdracht11GoBoard().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int chosen;

        System.out.print("Please enter the size of the board to draw (1-3): ");
        do {
            chosen = scanner.nextInt();
            switch (chosen) {
                case 1:
                    drawBoard(9);
                    break;
                case 2:
                    drawBoard(13);
                    break;
                case 3:
                    drawBoard(19);
                    break;
                default:
                    continue;
            }
            System.out.print("Please enter the size of the board to draw (1-3): ");
        } while (scanner.hasNextInt());
    }

    private void drawBoard(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j<n-1){

                }
            }
        }
    }
}
