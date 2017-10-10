package week_7.Opdracht2;

import java.util.Scanner;

public class DrawingsJava {
    public static void main(String[] args) {
        new DrawingsJava().run();
    }

    private void run() {
        Scanner s = new Scanner(System.in);
        int n;
        drawings();
        System.out.print("Your choice: ");
        while (s.hasNextInt()) {
            n = s.nextInt();
            switch (n) {
                case 1: house(); break;
                case 2: halfAPyramid(5); break;
                case 3: fullPyramid(3); break;
                case 0: System.out.println("Goodbye!");
                    System.exit(0);
            }
            drawings();
            System.out.print("Your choice: ");
        }
    }

    private void drawings() {
        System.out.println("***************************");
        System.out.println("*        Drawings!        *");
        System.out.println("***************************");
        System.out.println("* 1) Draw a house         *");
        System.out.println("* 2) Draw half a pyramid  *");
        System.out.println("* 3) Draw a full pyramid  *");
        System.out.println("* 0) Exit                 *");
        System.out.println("***************************");
    }

    private void house() {
        System.out.println("   +   ");
        System.out.println("  + +  ");
        System.out.println(" +   + ");
        System.out.println("+-----+");
        System.out.println("|  _  |");
        System.out.println("| | | |");
        System.out.println("| | | |");
        System.out.println("|_+_+_|");
    }

    private void halfAPyramid(int n) {
        for(int i=0;i<n;i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    private void fullPyramid(int n) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n-i;j++) {
                System.out.print(" ");
            }
            for(int k=0;k<=i;k++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }
}
