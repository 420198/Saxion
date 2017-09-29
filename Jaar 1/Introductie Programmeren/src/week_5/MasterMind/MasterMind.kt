package week_5.MasterMind

import java.util.Arrays
import java.util.Scanner

class MasterMind {
    private val solution = IntArray(MAX_PLACES)
    private var mySol = IntArray(MAX_PLACES)
    private val scanner = Scanner(System.`in`)

    fun run() {
        // Let the computer pick the solution...
        for (i in 0 until MAX_PLACES) {
            // Pick a number between 1 and 8 (inclusive)
            var unique = false

            var value = 0
            while (!unique) {
                // Pick a value
                value = (Math.random() * MAX_NUM + 1).toInt()

                // Assume the value is unique, unless proven otherwise...
                unique = (0 until i).none { solution[it] == value }
            }
            solution[i] = value
        }

        // We use Arrays.toString(...) to neatly print out the solution for us.
        println("[DEBUG] Solution: " + Arrays.toString(solution))

        println("Program created with ${MAX_TURNS} turns. Please guess numbers between 1 and ${MAX_NUM}")
        // Insert your code below..
        // While my turns dont exceed max turns
        for (MY_TURNS in 0 until MAX_TURNS) {
            // New index
            var i = 0
            //New strings, you can read what they mean
            var correctNumsCorrectPos = "Solution has the following nums in the correct position: "
            var correctNumsWrongPos = "Solution has the following nums in the wrong postion: "

            // Create solution
            while (i < MAX_PLACES) {
                print("Choose number: ")
                mySol[i] = scanner.nextInt()

                // why did you enter a number you cant use u twit, restart loop
                if (mySol[i] > MAX_NUM || mySol[i] <= 0) {
                    println("Chosen number exceeds boundaries!")
                    continue
                }

                // Number in my solution is equal to the one in the solution
                if (mySol[i] == solution[i]) {
                    correctNumsCorrectPos += mySol[i].toString() + "  "
                } else if (solution.contains(mySol[i])) {
                    //Number ain't correct but it is in the solution
                    correctNumsWrongPos += mySol[i].toString() + "  "
                }
                i++
            }

            //if solution has been found, return so it will exit the METHOD.
            if ((0 until MAX_PLACES).none { mySol[it] != solution[it] }) {
                println("Congrats, you guessed it you twit!")
                return
            }

            //print
            println(correctNumsCorrectPos)
            println(correctNumsWrongPos)

            // REINITIALISING IS IMPORTANT OTHERWISE THE NUMBERS IN ARRAY WONT BE RESET.
            mySol = IntArray(MAX_PLACES)
        }
        println("Too bad, you didn't guess it. Program stopping!")
    }

    companion object {
        private val MAX_NUM = 8
        private val MAX_PLACES = 4
        private val MAX_TURNS = 2

        @JvmStatic
        fun main(args: Array<String>) {
            MasterMind().run()
        }
    }
}