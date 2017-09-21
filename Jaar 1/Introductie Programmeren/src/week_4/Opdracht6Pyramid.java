package week_4;

import java.util.Scanner;

public class Opdracht6Pyramid {
    public static void main(String[] args) {
        new Opdracht6Pyramid().run();
    }

    private void run() {
        //Read scanner
        Scanner scanner = new Scanner(System.in);
        int num;
        System.out.print("How big does the period have to be: ");
        do {
            //Read num
            num = scanner.nextInt();

            //First loop, untill smaller or equal to the amount you want
            for (int i = 0; i <= num; i++) {

                //Second loop, it has to draw the amount of "#" so it takes the i of the first loop and cheecks against it
                for (int j = 0; j < i; j++) {
                    System.out.print("#");
                }
                System.out.println("");
            }
            System.out.print("\r\nHow big does the period have to be: ");
        }while (scanner.hasNextInt());
    }
}
