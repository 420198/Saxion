package week_7.Opdracht6

import java.util.*

class HangManKotlin {
    private val MAX_TURNS = 13
    private var turnsIncorrect = 0
    private val random = Random()
    private val scanner = Scanner(System.`in`)
    private val maskChar = '#'
    private var originalWord = ""
    private var maskedWord = "#############"
    private var lettersGuessedIncorrectly = ""
    private var lettersGuessedCorrectly = ""
    private val words = arrayOf("ANATOMIZATION", "WEIGHTLIFTING", "BOARDSAILINGS", "CARBONISATION", "DEMAGNETISING")

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            HangManKotlin().run()
        }
    }

    /**
     * First get a word at a random index and convert it to lower case
     * do{
     * if a guess wasn't correct. Increase the incorrect turns amount
     * else just print the board
     *
     * if the word was correct, exit out
     *
     * pretty print (can be removed to decrease amount of code)
     * } while word isn't correct and amount of turns hasnt exceeded MAX TURNS
     *
     * at the end, print what's needed
     */
    private fun run() {
        originalWord = words[random.nextInt(words.size)].toLowerCase()
        do {
            if (!takeAGuess()) {
                turnsIncorrect++
                Board.print(turnsIncorrect)
            } else {
                Board.print(turnsIncorrect)
            }

            if (wordCorrect()) {
                println("  You guessed the word: " + maskedWord)
                System.exit(0)
            }

            if (turnsIncorrect > 0) {
                println("         " + maskedWord)
            } else {
                println("                " + maskedWord)
            }

            println("                Incorrect: " + lettersGuessedIncorrectly)
        } while (!wordCorrect() && turnsIncorrect != MAX_TURNS)
        Board.print(turnsIncorrect)
        println("          YOU DIED!")
    }

    private fun wordCorrect(): Boolean {
        return maskedWord == originalWord
    }

    /**
     * Extra stuff is for a nice printing
     *
     * Check if read isn't of length > 1
     * Check if letter been used
     *
     * If the original word has the read in char:
     * Add to letters guessed correctly
     * un mask this character
     * else
     * Add to letters guessed incorrectly
     *
     * @return true or false
     */
    private fun takeAGuess(): Boolean {
        print("                Guess a letter: ")
        val read = scanner.next().toLowerCase()
        if (read.length != 1) {
            println("                Incorrect input!")
            return takeAGuess()
        }
        if (lettersGuessedIncorrectly.contains(read) || lettersGuessedCorrectly.contains(read)) {
            println("                Letter has been used")
            return takeAGuess()
        }

        return if (originalWord.contains(read)) {
            lettersGuessedCorrectly += read
            unMask()
            true
        } else {
            lettersGuessedIncorrectly += read
            false
        }
    }

    /**
     *
     *
     * First convert mask into a char array for easier checking
     *
     *
     * Next loop through the original word or maskedWord (doesn't matter as long as the length is the same)
     * Optimization: if masked is an unmasked character, skip the next loop and go towards the next iteration.
     * If that isn't the case, do the next loop and if the character at position i (in the original word) the same is as
     * the character at position j (in lettersGuessedCorrectly). Replace the masked character with the one in lettersGuessedCorrectly
     * Character at position j (in lettersGuessedCorrectly). Replace the masked character with the one in lettersGuessedCorrectly
     *
     *
     * Lastly set the masked character back into the string.
     *
     */
    private fun unMask() {
        val masked = maskedWord.toCharArray()
        (0 until originalWord.length)
                .filter { masked[it] == maskChar }
                .forEach { i ->
                    (0 until lettersGuessedCorrectly.length)
                            .filter { originalWord[i] == lettersGuessedCorrectly[it] }
                            .forEach { masked[i] = lettersGuessedCorrectly[it] }
                }
        maskedWord = String(masked)
    }
}