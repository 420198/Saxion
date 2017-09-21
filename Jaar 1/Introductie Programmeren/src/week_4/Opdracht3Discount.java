package week_4;

import java.util.Scanner;

public class Opdracht3Discount {
    public static void main(String[] args) {
        new Opdracht3Discount().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        //Price has to be higher than 0
        if(num>0 && num<100){
            System.out.println("DiscountedPrice: "+num*0.95);
        }else if (num >= 100 && num <=200){
            System.out.println("DiscountedPrice: "+num*0.90);
        }else if (num>200){
            System.out.println("DiscountedPrice: "+num*0.80);
        }else{
            System.out.println("Invalid price");
        }
    }
}
