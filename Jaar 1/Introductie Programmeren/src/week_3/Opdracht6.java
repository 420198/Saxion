package week_3;

import java.util.Scanner;

/**
 * Created by thama on 19-9-2017.
 */
public class Opdracht6 {
    public static void main(String[] args) {
        new Opdracht6().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        int numberOne;
        int numberTwo;

        System.out.print("Enter the first number: ");
        do{
            numberOne = scanner.nextInt();

            System.out.print("Enter the second number: ");
            numberTwo = scanner.nextInt();

            System.out.println(String.valueOf(numberOne) + " + "+String.valueOf(numberTwo)+ " = " + String.valueOf((numberOne+numberTwo)));
            System.out.println(String.valueOf(numberOne) + " - "+String.valueOf(numberTwo)+ " = " + String.valueOf((numberOne-numberTwo)));
            System.out.println(String.valueOf(numberTwo) + " - "+String.valueOf(numberOne)+ " = " + String.valueOf((numberTwo-numberOne)));
            System.out.println(String.valueOf(numberOne) + " * "+String.valueOf(numberTwo)+ " = " + String.valueOf((numberOne*numberTwo)));
            System.out.println(String.valueOf(numberOne) + " / "+String.valueOf(numberTwo)+ " = " + String.valueOf((numberOne/numberTwo)));
            System.out.println(String.valueOf(numberTwo) + " / "+String.valueOf(numberOne)+ " = " + String.valueOf((numberTwo/numberOne)));
            System.out.println(String.valueOf(numberOne) + " % "+String.valueOf(numberTwo)+ " = " + String.valueOf((numberOne%numberTwo)));
            System.out.println(String.valueOf(numberTwo) + " % "+String.valueOf(numberOne)+ " = " + String.valueOf((numberTwo%numberOne)));

            System.out.print("\r\nEnter the first number: ");
        }while (s.hasNextInt());

    }
}
