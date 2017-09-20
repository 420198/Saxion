package week_3;

import java.util.Scanner;

/**
 * Created by thama on 19-9-2017.
 */
public class Opdracht8 {
    public static void main(String[] args) {
        new Opdracht8().run();
    }

    private void run() {
        //Create vars
        double numOne;
        double numTwo;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input value: ");

        //Blah blah, repetitive commentating
        do{
            numOne = scanner.nextDouble();
            System.out.print("Input value: ");
            numTwo = scanner.nextDouble();

            if(numOne > numTwo){
                System.out.println("Biggest value is " + String.valueOf(numOne));
            }else if(numOne < numTwo){
                System.out.println("Biggest value is " + String.valueOf(numTwo));
            }else{
                System.out.println("Values are the same");
            }
            System.out.print("\r\nInput value: ");
        }while (scanner.hasNextDouble());
    }
}