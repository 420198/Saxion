package week_8.AanhangerTest;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AanhangerTest {
    public static void main(String[] args) {
        new AanhangerTest().run();
    }

    private Scanner s = new Scanner(System.in);
    private int choice = -1;

    private ArrayList<String> kleineAanhangers = new ArrayList<>();
    private ArrayList<String> groteAanhangers = new ArrayList<>();

    private void run() {
        toonScherm();
        maakKeuze();
    }

    private void maakKeuze() {
        Scanner s = new Scanner(System.in);
        System.out.print("Maak keuze: ");
        if (s.hasNextInt()) {
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    huurKleineAanhanger();
                    break;
                case 2:
                    huurGroteAanhanger();
                    break;
                case 3:
                    toonOverzicht();
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Foute invoer");
                    maakKeuze();
            }
        } else {
            System.out.println("Foute invoer!");
            maakKeuze();
        }
    }

    private void toonScherm() {
        System.out.println("******************************************\r\n " +
                "* De Trekhaak \n" +
                "****************************************** \n" +
                "* 1) Kleine aanhanger verhuren \n" +
                "* 2) Grote aanhanger verhuren \n" +
                "* 3) Overzicht tonen \n" +
                "* 9) Afsluiten    \n" +
                "******************************************");
    }

    /**
     * Huur een kleine aanhanger
     */
    private void huurKleineAanhanger() {
        if (kleineAanhangers.size() == 5) {
            System.out.println("Helaas, alle kleine aanhangwagens zijn al verhuurd!");
            run();
        } else {
            System.out.print("Wat is de achternaam van de klant? ");
            String naam = s.next();
            leesKilos(naam, 750, kleineAanhangers);
        }
    }

    /**
     * Huur een grote aanhanger
     */
    private void huurGroteAanhanger() {
        if (groteAanhangers.size() == 3) {
            System.out.println("Helaas, alle kleine aanhangwagens zijn al verhuurd!");
            run();
        } else {
            System.out.print("Wat is de achternaam van de klant? ");
            String naam = s.next();
            leesKilos(naam, 3000, groteAanhangers);
        }
    }

    /**
     * Lees het aantal kilos in, alle foute input wordt ingelezen
     *
     * @param naam      de naam van de huurder
     * @param margin    wanneer het ingeelezen kilo antal groter is dan de margin, gaat ie in de if
     * @param aanhanger de aanhanger waar de huruder uiteindelijk wordt toegevoegd
     */
    private void leesKilos(String naam, int margin, ArrayList<String> aanhanger) {
        Scanner s = new Scanner(System.in);
        System.out.println("Wat is het maximale laadgewicht (in kg)?");
        if (s.hasNextDouble() || s.hasNextInt()) {
            double mijnKilos = s.nextDouble();
            if (mijnKilos > margin) {
                System.out.println("Let op! Het maximale laadvermogen van de aanhangwagen is 750 kg. De lading is " + (mijnKilos - 750) + " kg te zwaar! ");
                System.out.print("Weet u zeker dat u de aanhangwagen wilt verhuren (j/n)? ");
                leesTeveelInput(aanhanger, naam);
            } else {
                aanhanger.add(naam);
                run();
            }
        } else {
            System.out.print("Ongeldige input, probeer opnieuw: ");
            leesKilos(naam, margin, aanhanger);
        }
    }

    /**
     * Hier kom je in wanneer een gebruiker een te hoge kilo aantal heeft ingevuld
     * Alle foute input wordt afgehandeld
     *
     * @param aanhanger, de aanhanger lijst waaraan de huurder wordt toegevoegd
     * @param naam,      de naam van degene die aan de lijst wordt toegevoegd
     */
    private void leesTeveelInput(ArrayList<String> aanhanger, String naam) {
        Scanner s = new Scanner(System.in);
        String myChoice = s.next();
        switch (myChoice) {
            case "j":
                aanhanger.add(naam);
                run();
                break;
            case "n":
                run();
                break;
            default:
                System.out.print("Verkeerde input, nieuwe input: ");
                leesTeveelInput(aanhanger, naam);
                break;
        }
    }

    /**
     * Print alle aanhangwagens
     */
    private void toonOverzicht() {
        System.out.println("Kleine aanhangwagens verhuurd:");
        for (int i = 0; i < kleineAanhangers.size(); i++) {
            System.out.println("\tKleine aanhangwagen " + (i + 1) + ": " + kleineAanhangers.get(i));
        }
        if (kleineAanhangers.size() == 5) {
            System.out.println("Er zijn geen kleine aanhangwagens meer beschikbaar \r\n");
        } else {
            System.out.println("Er zijn nog " + (5 - kleineAanhangers.size()) + "  van de 5 kleine aanhangwagens beschikbaar. \r\n");
        }

        System.out.println("Grote aanhangwagens verhuurd:");
        for (int i = 0; i < groteAanhangers.size(); i++) {
            System.out.println("\tGrote aanhangwagen " + (i + 1) + ": " + groteAanhangers.get(i));
        }
        if (groteAanhangers.size() == 5) {
            System.out.println("Er zijn geen grote aanhangwagens meer beschikbaar \r\n");
        } else {
            System.out.println("Er zijn nog " + (3 - groteAanhangers.size()) + "  van de 3 grote aanhangwagens beschikbaar. \r\n");
        }
        System.out.println("In totaal zijn er nog " + ((5 - kleineAanhangers.size()) + (3 - groteAanhangers.size())) + " aanhangwagen(s) beschikbaar");

        run();
    }
}