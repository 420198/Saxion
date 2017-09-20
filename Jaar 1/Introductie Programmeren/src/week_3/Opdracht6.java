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

        //Create variables
        Scanner scanner = new Scanner(System.in);
        int numberOne;
        int numberTwo;

        System.out.print("Enter the first number: ");

        //Loopy
        do{
            //Read number one
            numberOne = scanner.nextInt();

            System.out.print("Enter the second number: ");

            //Read number two
            numberTwo = scanner.nextInt();

            //Print magic
            System.out.println(String.valueOf(numberOne) + " + "+String.valueOf(numberTwo)+ " = " + String.valueOf((numberOne+numberTwo)));
            System.out.println(String.valueOf(numberOne) + " - "+String.valueOf(numberTwo)+ " = " + String.valueOf((numberOne-numberTwo)));
            System.out.println(String.valueOf(numberTwo) + " - "+String.valueOf(numberOne)+ " = " + String.valueOf((numberTwo-numberOne)));
            System.out.println(String.valueOf(numberOne) + " * "+String.valueOf(numberTwo)+ " = " + String.valueOf((numberOne*numberTwo)));
            System.out.println(String.valueOf(numberOne) + " / "+String.valueOf(numberTwo)+ " = " + String.valueOf((numberOne/numberTwo)));
            System.out.println(String.valueOf(numberTwo) + " / "+String.valueOf(numberOne)+ " = " + String.valueOf((numberTwo/numberOne)));
            System.out.println(String.valueOf(numberOne) + " % "+String.valueOf(numberTwo)+ " = " + String.valueOf((numberOne%numberTwo)));
            System.out.println(String.valueOf(numberTwo) + " % "+String.valueOf(numberOne)+ " = " + String.valueOf((numberTwo%numberOne)));

            System.out.println("\r\nEnter the first number: ");
        }while (scanner.hasNextInt());
        //End loopy
    }
}
