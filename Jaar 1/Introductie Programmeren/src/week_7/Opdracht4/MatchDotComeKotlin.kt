package week_7.Opdracht4

import java.util.*

class MatchDotComeKotlin {
    private var matchCount = 21
    private val PLAYER_ONE = 1
    private val PLAYER_TWO = 2
    private var CURR_PAYER = 2

    private var message: String? = null
    private val s = Scanner(System.`in`)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            MatchDotComeKotlin().run()
        }
    }

    private fun run() {
        do {
            nextPlayer()
            printMatches()
            takeMatches()
        } while (playing())
        println(message)
    }

    private fun takeMatches() {
        print("\r\nPlayer $CURR_PAYER, how many matches do you take (1, 2 or 3)? ")
        try {
            val num = s.nextInt()
            if (num in 1..3) {
                matchCount -= num
            } else {
                takeMatches()
            }
        } catch (e: Exception) {
            println("You done fucked up!")
            System.exit(0)
        }

    }

    private fun nextPlayer() {
        CURR_PAYER = if (CURR_PAYER == PLAYER_ONE) {
            PLAYER_TWO
        } else {
            PLAYER_ONE
        }
        this.message = "\r\nPlayer $CURR_PAYER has lost!!"
    }

    private fun printMatches() {
        for (i in 0 until matchCount) {
            print("|")
        }
        print(" ($matchCount)")
    }

    private fun playing(): Boolean {
        return matchCount > 0
    }
}