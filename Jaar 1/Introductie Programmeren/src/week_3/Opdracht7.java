package week_3;

import java.util.Scanner;

/**
 * Created by thama on 19-9-2017.
 */
public class Opdracht7 {
    public static void main(String[] args) {
        new Opdracht7().run();
    }

    private void run() {
        //Create var
        int weight;
        double height;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your height in meters: ");

        //Loopy
        do {
            //Read height
            height = scanner.nextDouble();

            System.out.print("Enter your weight in kg: ");

            //Read weight
            weight = scanner.nextInt();

            //Calculating magic
            double bmi = weight / (height * 2);
            System.out.println("Your BMI is: " + String.valueOf(bmi));

            //If-else
            if(bmi < 18.5){
                System.out.println("Underweight!");
            }else if(bmi >= 18.5 && bmi <25){
                System.out.println("Normal weight!");
            }else if(bmi >=25 && bmi < 30){
                System.out.println("Overweight!");
            }else{
                System.out.println("OBESE FUCK!");
            }
            System.out.println("\r\nEnter your height in meters: ");

            //Read in ints and doubles
        } while (scanner.hasNextInt() || scanner.hasNextDouble());
    }
}