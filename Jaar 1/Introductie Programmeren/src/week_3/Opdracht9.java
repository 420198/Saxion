package week_3;

import java.util.Scanner;

/**
 * Created by thama on 19-9-2017.
 */
public class Opdracht9 {
    public static void main(String[] args) {
        new Opdracht9().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int number;

        System.out.print("Input: ");

        //Explains itself
        do{
           number = scanner.nextInt();
           if(number >2147){
               System.out.println("A 32 bit integer can only display numbers between -2.147.483.648 and 2.147.483.647");
               System.out.println(String.valueOf(number)+ " * 1000000 = "+ String.valueOf((number*1000000)));
           }else{
               System.out.println(String.valueOf(number)+ " * 1000000 = "+ String.valueOf((number*1000000)));
           }
            System.out.print("\r\nInput: ");
        }while (scanner.hasNextInt());
        System.out.println("You cant put a number into a goddamn int you twit!");
    }
}
