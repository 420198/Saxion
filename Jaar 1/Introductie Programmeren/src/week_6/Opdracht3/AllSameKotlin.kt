package week_6.Opdracht3

class AllSameKotlin {
    private fun run() {
        println(allSame(1, 2, 3))
        println(allSame(2, 2, 2))
    }

    private fun allSame(a: Int, b: Int, c: Int): Boolean {
        return a==b && a ==c
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            AllSameKotlin().run();
        }
    }
}