package week_6.Opdracht12

import java.util.*

class TicTacToeKotlin {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            TicTacToeKotlin().run()
        }
    }

    //2D array
    private val objects = arrayOf(arrayOf(" ", " ", " "), arrayOf(" ", " ", " "), arrayOf(" ", " ", " "))
    private var message: String? = null
    private val scanner = Scanner(System.`in`)

    private val PLAYER_ONE = 1
    private val PLAYER_TWO = 2
    private var CURR_PAYER = 2

    /**
     * While solution hasn't been found and board isn't full
     * ->Get the next player
     * ->Print board
     * ->Choose position the player wants
     */
    private fun run() {
        do {
            nextPlayer()
            printBoard()
            choosePos()
        } while (!solutionFound() && !boardFull())
        printBoard()
        println(message)
    }

    /**
     * Choose ur position
     */
    private fun choosePos() {
        print("\r\nPlayer $CURR_PAYER's move is: ")
        var pos = scanner.nextInt()
        if (pos < 1 || pos > 9) {
            println("This number is out of bounds")
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
        if (objects[dimOne][dimTwo] !== " ") {
            println("Position already taken")
            choosePos()
        } else {
            objects[dimOne][dimTwo] = if (CURR_PAYER == PLAYER_ONE) {
                "X"
            } else {
                "O"
            }
        }
    }

    /**
     * Sets the next player based on the current one
     */
    private fun nextPlayer() {
        CURR_PAYER = if (CURR_PAYER == PLAYER_ONE) {
            PLAYER_TWO
        } else {
            PLAYER_ONE
        }
        this.message = "\r\nPlayer $CURR_PAYER has won!"
    }

    /**
     * If even one of these conditions is true then a solution was found
     * @return true or false based on one of these conditions
     */
    private fun solutionFound(): Boolean {
        return if (objects[0][0] == objects[0][1] && objects[0][0] == objects[0][2]) objects[0][0] != " "
        else if (objects[1][0] == objects[1][1] && objects[1][0] == objects[1][2]) objects[1][0] != " "
        else if (objects[2][0] == objects[2][1] && objects[2][0] == objects[2][2]) objects[2][0] != " "
        else if (objects[0][0] == objects[1][0] && objects[0][0] == objects[2][0]) objects[0][0] != " "
        else if (objects[0][1] == objects[1][1] && objects[0][1] == objects[2][1]) objects[0][1] != " "
        else if (objects[0][2] == objects[1][2] && objects[0][2] == objects[2][2]) objects[0][2] != " "
        else if (objects[0][0] == objects[1][1] && objects[0][0] == objects[2][2]) objects[0][0] != " "
        else objects[0][2] == objects[1][1] && objects[0][2] == objects[2][0] && objects[0][2] != " "
    }

    /**
     * Check if board is full
     * @return
     */
    private fun boardFull(): Boolean {
        for (`object` in objects) {
            `object`.filter { it == " " }.forEach { return false }
        }
        this.message = "\r\nThis game is a draw!"
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
            for (j in 0 until objects[i].size) {
                print(objects[i][j])
                if (j < objects[i].size - 1) {
                    print(" | ")
                }
            }
        }
    }
}