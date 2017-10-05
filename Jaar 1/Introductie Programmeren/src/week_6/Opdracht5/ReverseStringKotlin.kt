package week_6.Opdracht5

class ReverseStringKotlin {
    private fun run() {
        val str = "Hello World"
        println(str)
        println(reverse(str))
        println(reverseAnother(str))
    }

    private fun reverse(str: String): String {
        return StringBuilder(str).reverse().toString()
    }

    private fun reverseAnother(str: String): String {
        val length = str.length
        val des = StringBuilder(length)

        for (i in length - 1 downTo 0) {
            des.append(str[i])
        }
        return des.toString()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            ReverseStringKotlin().run();
        }
    }
}