package week_6.Opdracht12

import java.util.*

class TicTacToeKotlin {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }
    }

    //2D array
    private val objects = arrayOf(arrayOf(" ", " ", " "), arrayOf(" ", " ", " "), arrayOf(" ", " ", " "))
    private val scanner = Scanner(System.`in`)

    private val PLAYER_ONE = 1
    private val PLAYER_TWO = 2
    private var CURR_PAYER = 2

    private fun run() {
        do {
            nextPlayer()
            printBoard()
            choosePos()
        } while (!boardFull() && !solutionFound())
        printBoard()
    }

    private fun choosePos() {
        println("\r\n Player $CURR_PAYER's move is")
        var pos = scanner.nextInt()
        if (pos < 1 && pos > 9) {
            choosePos()
        } else {
            pos--
            when {
                pos <= 2 -> setPos(0, pos)
                pos in 3..5 -> setPos(1, pos % 3)
                else -> setPos(2, pos % 3)
            }
        }
    }

    /**
     * Set X or O at dimension two of dimension one
     *
     * @param dimOne dimension one
     * @param dimTwo dimension two
     */
    private fun setPos(dimOne: Int, dimTwo: Int) {
        if (playerOneActive()) {
            objects[dimOne][dimTwo] = "X"
        } else {
            objects[dimOne][dimTwo] = "O"
        }
    }

    private fun nextPlayer() {
        CURR_PAYER = if (CURR_PAYER == PLAYER_ONE) {
            PLAYER_TWO
        } else {
            PLAYER_ONE
        }
    }

    private fun playerOneActive(): Boolean {
        return CURR_PAYER == PLAYER_ONE
    }


    private fun solutionFound(): Boolean {
        if (objects[0][0] == objects[0][1] && objects[0][0] == objects[0][2]) return objects[0][0] != " "
        else if (objects[1][0] == objects[1][1] && objects[1][0] == objects[1][2]) return objects[0][0] != " "
        else if (objects[2][0] == objects[2][1] && objects[2][0] == objects[2][2]) return objects[0][0] != " "
        else if (objects[0][0] == objects[1][0] && objects[0][0] == objects[2][0]) return objects[0][0] != " "
        else if (objects[0][1] == objects[1][1] && objects[0][1] == objects[2][1]) return objects[0][0] != " "
        else if (objects[0][2] == objects[1][2] && objects[0][1] == objects[2][2]) return objects[0][0] != " "
        else if (objects[0][0] == objects[1][1] && objects[0][0] == objects[2][2]) return objects[0][0] != " "
        else if (objects[0][2] == objects[1][1] && objects[0][2] == objects[2][0]) return objects[0][0] != " "
        return false
    }

    /**
     * Check if borard is full
     * @return
     */
    private fun boardFull(): Boolean {
        for (`object` in objects) {
            `object`.filter { it == " " }.forEach { return false }
        }
        return true
    }


    /**
     * Print het bord
     */
    private fun printBoard() {
        for (i in objects.indices) {
            if (i > 0) {
                println("\r\n---------")
            }
            for (j in 0..objects[i].size - 1) {
                print(objects[i][j])
                if (j < objects[i].size - 1) {
                    print(" | ")
                }
            }
        }
    }
}