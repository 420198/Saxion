package week_6.Opdracht10

class PyramidKotlin{
    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            PyramidKotlin().run();
        }
    }

    private fun run() {
        pyramid(23)
    }

    private fun pyramid(n: Int) {
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