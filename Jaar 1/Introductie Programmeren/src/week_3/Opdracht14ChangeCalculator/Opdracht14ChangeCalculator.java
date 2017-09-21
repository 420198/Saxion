package week_3.Opdracht14ChangeCalculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Opdracht14ChangeCalculator {
    //Create new money list
    private ArrayList<Money> moneyList = new ArrayList<Money>() {{
        add(new Money(10000, "euro"));
        add(new Money(5000, "euro"));
        add(new Money(2000, "euro"));
        add(new Money(1000, "euro"));
        add(new Money(500, "euro"));
        add(new Money(200, "euro"));
        add(new Money(100, "euro"));
        add(new Money(50, "cent"));
        add(new Money(20, "cent"));
        add(new Money(10, "cent"));
        add(new Money(5, "cent"));
    }};

    //Create scanner
    private Scanner scanner = new Scanner(System.in);

    //More vars
    private int dueInCents, paidInCents;

    public static void main(String[] args) {
        new Opdracht14ChangeCalculator().run();
    }

    private void run() {
        //Read due
        System.out.print("Amount due (in cents): ");
        dueInCents = scanner.nextInt();

        //Read paid
        System.out.print("Amount paid (in cents): ");
        paidInCents = scanner.nextInt();

        //Extra checks for assholes
        if (paidInCents < dueInCents) {
            System.out.println("Scammer.....i like you");
        } else {
            //Change calculator
            System.out.println("Change: " + String.valueOf(paidInCents - dueInCents));
            calcChange(paidInCents - dueInCents);

            //Print the money
            for (Money money : moneyList) {
                if (money.getType().equals("euro")) {
                    //Divider needed
                    System.out.println(money.getMoney() / 100 + " " + money.getType() + ": " + money.getAmountChosen());
                } else {
                    System.out.println(money.getMoney() + " " + money.getType() + ": " + money.getAmountChosen());
                }
            }
        }
    }

    /**
     * Method to calculate change
     * <P>
     *     Loop through the advanced loop.
     *     First get the object and check the change against the amounr of money that object is
     *     Keep on adding to it and decrease the change.
     * </P>
     * @param change
     */
    private void calcChange(int change) {
        for (Money money : moneyList) {
            while (change >= money.getMoney()) {
                money.addChosen();
                change -= money.getMoney();
            }
        }
    }
}
