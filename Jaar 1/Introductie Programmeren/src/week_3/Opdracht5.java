package week_3;

import java.util.HashMap;
import java.util.Scanner;

public class Opdracht5 {
    public static void main(String[] args) {
        new Opdracht5().run();
    }

    private void run(){
        //Put everything into a map so you dont get a million if-else
        HashMap<Integer,String> roman = new HashMap<Integer, String>(){{
            put(1,"I");
            put(2,"II");
            put(3,"III");
            put(4,"IV");
            put(5,"V");
            put(6,"VI");
            put(7,"VII");
            put(8,"VIII");
            put(9,"IX");
            put(10,"X");
        }};

        //Create a scanner
        Scanner s = new Scanner(System.in);

        //Create variable
        int toTranslate;

        System.out.println("Enter a number between 1 and 10: ");

        //loop
        do{
            //Read in the number
            toTranslate = s.nextInt();

            //Check if number is between x and y
            if(toTranslate>0 && toTranslate < 11){
                System.out.println("Roman numeral value: "+roman.get(toTranslate));
            }else{
                //else
                System.out.println("Incorrect number, asshat. Type \"exit\" to exit the loop!");
            }
            System.out.println("Enter a number between 1 and 10: ");
        }while (s.hasNextInt());
    }
}