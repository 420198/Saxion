package week_7.Opdracht1;

import week_7.Opdracht1.Model.Tax;

import java.util.Scanner;

public class TaxJava {
    private Tax[] tax = new Tax[4];
    private Scanner s = new Scanner(System.in);
    private int salary, totalTax;

    public static void main(String[] args) {
        new TaxJava().run();
    }

    private void run() {
        System.out.print("Voer uw loon in: ");
        salary = s.nextInt();
        tax[0] = new Tax(0.5200, 67073);
        tax[1] = new Tax(0.4080, 33792);
        tax[2] = new Tax(0.4080, 19983);
        tax[3] = new Tax(0.3655, 0);
        for (int i = 0, j = tax.length; i < tax.length; i++) {
            if(salary < tax[i].getTax()){
                System.out.println("Schijf "+j-- + ": "+tax[i].getTaxPercentage()*100 +" over 0 = 0");
            }else{
                int myTax =(int) ((salary - tax[i].getTax()) * tax[i].getTaxPercentage());
                totalTax += myTax;
                System.out.println("Schijf "+(j--) + ": "+(100*tax[i].getTaxPercentage()) + " over "+ (salary-tax[i].getTax()) + " = "+myTax);


                salary-=(salary - tax[i].getTax());
            }
        }
        System.out.println("Totaal: " + totalTax);
    }
}
