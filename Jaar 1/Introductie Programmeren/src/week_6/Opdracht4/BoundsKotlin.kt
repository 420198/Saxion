package week_6.Opdracht4

import java.util.*

class BoundsKotlin{

    private val random = Random()
    private fun run() {
        println(getRandInBounds(21, 126))
    }

    private fun getRandInBounds(lower: Int, higher: Int): String {
        return (random.nextInt(higher - lower) + lower).toString()
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            BoundsKotlin().run();
        }
    }
}