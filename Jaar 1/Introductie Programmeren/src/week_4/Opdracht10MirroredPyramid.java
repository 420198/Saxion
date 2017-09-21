package week_4;

import java.util.Scanner;

public class Opdracht10MirroredPyramid {
    public static void main(String[] args) {
        new Opdracht10MirroredPyramid().run();
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
                //Mirror the second loop and put an if so you only print a # fi j=>i
                for (int j = num; j > 0; j--) {
                    if(i< j){
                        System.out.print(" ");
                    }else {
                        System.out.print("#");
                    }
                }
                System.out.println("");
            }
            System.out.print("\r\nHow big does the period have to be: ");
        }while (scanner.hasNextInt());
    }
}
