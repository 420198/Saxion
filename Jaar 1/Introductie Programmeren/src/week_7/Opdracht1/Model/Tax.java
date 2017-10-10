package week_7.Opdracht1.Model;

public class Tax {
    private double taxPercentage;
    private int tax;

    public Tax(double taxPercentage, int tax) {
        this.taxPercentage = taxPercentage;
        this.tax = tax;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public int getTax() {
        return tax;
    }
}
