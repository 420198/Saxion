package week_4;

import java.util.Scanner;

public class Opdracht4SimplePostal {
    public static void main(String[] args) {
        new Opdracht4SimplePostal().run();
    }

    private void run() {
        //Scanner
        Scanner scanner = new Scanner(System.in);

        //Create var
        int num;

        System.out.print("Give a postal code: ");
        do{
            //Read in num
            num = scanner.nextInt();
            //Checker
            if(num>=1000 && num <=9999){
                System.out.println("Postal code accepted!");

                //Break out the loop if correct
                break;
            }else if(num<1000){
                System.out.println("Invalid postal code (too low)! Try again.");
            }else{
                System.out.println("Invalid postal code (too high)! Try again.");
            }
            System.out.print("Give a postal code: ");
        }while (scanner.hasNextInt());
    }
}
