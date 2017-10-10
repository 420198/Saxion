package week_7.Opdracht3

import java.util.*

class VowelCountKotlin {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            VowelCountKotlin().run()
        }
    }

    private fun run() {
        val s = Scanner(System.`in`)
        val str: String
        print("Input your sentence: ")
        str = s.nextLine()
        println("This sentence contains " + vowelCount(str) + " vowels.")
    }

    /**
     * Replace all the characters that do NOT equal (^ in the regex) a o i u y or e
     *
     * @param s string to check
     * @return vowel amount
     */
    private fun vowelCount(s: String): Int {
        return s.toLowerCase().replace("[^aoiuye]".toRegex(), "").length
    }
}