package week_6.Opdracht9

import java.util.*

class InBoundsKotlin{

    private fun run() {
        val scanner = Scanner(System.`in`)
        var chosen: Double
        print("Input a number between $LOWER_BOUND and $UPPER_BOUND: ")

        do {
            chosen = scanner.nextDouble()
            if (inBounds(chosen)) {
                break
            }
            print("Incorrect, input another number: ")
        } while (!inBounds(chosen))
    }

    private fun inBounds(chosen: Double): Boolean {
        return chosen in LOWER_BOUND..UPPER_BOUND
    }

    companion object {
        private val random = Random()
        private val LOWER_BOUND = random.nextDouble() * 50
        private val UPPER_BOUND = random.nextDouble() * 50 + LOWER_BOUND

        @JvmStatic
        fun main(args: Array<String>){
            InBoundsKotlin().run()
        }
    }
}