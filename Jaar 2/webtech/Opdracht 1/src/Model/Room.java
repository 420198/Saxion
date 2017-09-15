package Model;

/**
 * Created by Frank on 01-09-16.
 */
public class Room {
    private String naam;
    private int vierkanteMeters;
    private double prijs;
    private Huurder huurder;
    private Verhuurder verhuurder;

    /**
     * Constructor voor nieuwe Room
     * @param naam String
     * @param vierkanteMeters Integer
     * @param prijs double
     * @param verhuurder Verhuurder
     */
    public Room(String naam, int vierkanteMeters, double prijs, Verhuurder verhuurder){
        this.naam = naam;
        this.vierkanteMeters = vierkanteMeters;
        this.prijs = prijs;
        this.verhuurder = verhuurder;
    }

    //Getters
    public String getNaam() {
        return naam;
    }

    public int getVierkanteMeters() {
        return vierkanteMeters;
    }

    public double getPrijs() {
        return prijs;
    }

    public Huurder getHuurder() {
        return huurder;
    }

    public void setHuurder(Huurder huurder) {
        this.huurder = huurder;
    }

    public Verhuurder getVerhuurder() {
        return verhuurder;
    }

    public void setVerhuurder(Verhuurder verhuurder) {
        this.verhuurder = verhuurder;
    }

    /**
     * to string methode
     * @return String
     */
    @Override
    public String toString() {
        return "Naam= " + naam  +
                "<br> vierkanteMeters= " + vierkanteMeters +
                "<br> prijs= " + prijs ;
    }
}
