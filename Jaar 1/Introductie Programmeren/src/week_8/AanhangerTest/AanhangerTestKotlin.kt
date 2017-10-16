package week_8.AanhangerTest

import java.util.*

class AanhangerTestKotlin {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            AanhangerTestKotlin().run()
        }
    }

    private val s = Scanner(System.`in`)
    private var choice = -1

    private val kleineAanhangers = ArrayList<String>()
    private val groteAanhangers = ArrayList<String>()

    private fun run() {
        toonScherm()
        maakKeuze()
    }

    private fun maakKeuze() {
        val s = Scanner(System.`in`)
        print("Maak keuze: ")
        if (s.hasNextInt()) {
            choice = s.nextInt()
            when (choice) {
                1 -> huurKleineAanhanger()
                2 -> huurGroteAanhanger()
                3 -> toonOverzicht()
                9 -> {
                    System.exit(0)
                    println("Foute invoer")
                    maakKeuze()
                }
                else -> {
                    println("Foute invoer")
                    maakKeuze()
                }
            }
        } else {
            println("Foute invoer!")
            maakKeuze()
        }
    }

    private fun toonScherm() {
        println("******************************************\r\n " +
                "* De Trekhaak \n" +
                "****************************************** \n" +
                "* 1) Kleine aanhanger verhuren \n" +
                "* 2) Grote aanhanger verhuren \n" +
                "* 3) Overzicht tonen \n" +
                "* 9) Afsluiten    \n" +
                "******************************************")
    }

    /**
     * Huur een kleine aanhanger
     */
    private fun huurKleineAanhanger() {
        if (kleineAanhangers.size == 5) {
            println("Helaas, alle kleine aanhangwagens zijn al verhuurd!")
            run()
        } else {
            print("Wat is de achternaam van de klant? ")
            val naam = s.next()
            leesKilos(naam, 750, kleineAanhangers)
        }
    }

    /**
     * Huur een grote aanhanger
     */
    private fun huurGroteAanhanger() {
        if (groteAanhangers.size == 3) {
            println("Helaas, alle kleine aanhangwagens zijn al verhuurd!")
            run()
        } else {
            print("Wat is de achternaam van de klant? ")
            val naam = s.next()
            leesKilos(naam, 3000, groteAanhangers)
        }
    }

    /**
     * Lees het aantal kilos in, alle foute input wordt ingelezen
     *
     * @param naam      de naam van de huurder
     * @param margin    wanneer het ingeelezen kilo antal groter is dan de margin, gaat ie in de if
     * @param aanhanger de aanhanger waar de huruder uiteindelijk wordt toegevoegd
     */
    private fun leesKilos(naam: String, margin: Int, aanhanger: ArrayList<String>) {
        val s = Scanner(System.`in`)
        println("Wat is het maximale laadgewicht (in kg)?")
        if (s.hasNextDouble() || s.hasNextInt()) {
            val mijnKilos = s.nextDouble()
            if (mijnKilos > margin) {
                println("Let op! Het maximale laadvermogen van de aanhangwagen is 750 kg. De lading is " + (mijnKilos - 750) + " kg te zwaar! ")
                print("Weet u zeker dat u de aanhangwagen wilt verhuren (j/n)? ")
                leesTeveelInput(aanhanger, naam)
            } else {
                aanhanger.add(naam)
                run()
            }
        } else {
            print("Ongeldige input, probeer opnieuw: ")
            leesKilos(naam, margin, aanhanger)
        }
    }

    /**
     * Hier kom je in wanneer een gebruiker een te hoge kilo aantal heeft ingevuld
     * Alle foute input wordt afgehandeld
     *
     * @param aanhanger, de aanhanger lijst waaraan de huurder wordt toegevoegd
     * @param naam,      de naam van degene die aan de lijst wordt toegevoegd
     */
    private fun leesTeveelInput(aanhanger: ArrayList<String>, naam: String) {
        val s = Scanner(System.`in`)
        val myChoice = s.next()
        when (myChoice) {
            "j" -> {
                aanhanger.add(naam)
                run()
            }
            "n" -> run()
            else -> {
                print("Verkeerde input, nieuwe input: ")
                leesTeveelInput(aanhanger, naam)
            }
        }
    }

    /**
     * Print alle aanhangwagens
     */
    private fun toonOverzicht() {
        println("Kleine aanhangwagens verhuurd:")
        for (i in kleineAanhangers.indices) {
            println("\tKleine aanhangwagen " + (i + 1) + ": " + kleineAanhangers[i])
        }
        if (kleineAanhangers.size == 5) {
            println("Er zijn geen kleine aanhangwagens meer beschikbaar \r\n")
        } else {
            println("Er zijn nog " + (5 - kleineAanhangers.size) + "  van de 5 kleine aanhangwagens beschikbaar. \r\n")
        }

        println("Grote aanhangwagens verhuurd:")
        for (i in groteAanhangers.indices) {
            println("\tGrote aanhangwagen " + (i + 1) + ": " + groteAanhangers[i])
        }
        if (groteAanhangers.size == 5) {
            println("Er zijn geen grote aanhangwagens meer beschikbaar \r\n")
        } else {
            println("Er zijn nog " + (3 - groteAanhangers.size) + "  van de 3 grote aanhangwagens beschikbaar. \r\n")
        }
        println("In totaal zijn er nog " + (5 - kleineAanhangers.size + (3 - groteAanhangers.size)) + " aanhangwagen(s) beschikbaar")

        run()
    }
}