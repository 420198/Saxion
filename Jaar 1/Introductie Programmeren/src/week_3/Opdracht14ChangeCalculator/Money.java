package week_3.Opdracht14ChangeCalculator;

public class Money {
    private int money;
    private int amountChosen;
    private String type;

    /**
     * New money constructor
     * @param money is the money
     * @param type is the type
     */
    public Money(int money, String type) {
        this.money = money;
        this.type = type;
        this.amountChosen = 0;
    }

    /**
     * increase amount of biljets
     */
    public void addChosen(){
        this.amountChosen++;
    }

    /**
     * Getters
     */
    public int getAmountChosen() {
        return amountChosen;
    }

    public int getMoney() {
        return money;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Money{" +
                "money=" + money +
                ", amountChosen=" + amountChosen +
                ", type='" + type + '\'' +
                '}';
    }
}
