package week_7.Opdracht2

import java.util.*

class DrawingsKotlin {
    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            DrawingsKotlin().run();
        }
    }

    private fun run() {
        val s = Scanner(System.`in`)
        var n: Int
        drawings()
        print("Your choice: ")
        while (s.hasNextInt()) {
            n = s.nextInt()
            when (n) {
                1 -> house()
                2 -> halfAPyramid(5)
                3 -> fullPyramid(3)
                0 -> {
                    println("Goodbye!")
                    System.exit(0)
                }
            }
            drawings()
            print("Your choice: ")
        }
    }

    private fun drawings() {
        println("***************************")
        println("*        Drawings!        *")
        println("***************************")
        println("* 1) Draw a house         *")
        println("* 2) Draw half a pyramid  *")
        println("* 3) Draw a full pyramid  *")
        println("* 0) Exit                 *")
        println("***************************")
    }

    private fun house() {
        println("   +   ")
        println("  + +  ")
        println(" +   + ")
        println("+-----+")
        println("|  _  |")
        println("| | | |")
        println("| | | |")
        println("|_+_+_|")
    }

    private fun halfAPyramid(n: Int) {
        for (i in 0 until n) {
            for (j in 0..i) {
                print("#")
            }
            println()
        }
    }

    private fun fullPyramid(n: Int) {
        for (i in 0 until n) {
            for (j in 0 until n - i) {
                print(" ")
            }
            for (k in 0..i) {
                print("# ")
            }
            println()
        }
    }
}