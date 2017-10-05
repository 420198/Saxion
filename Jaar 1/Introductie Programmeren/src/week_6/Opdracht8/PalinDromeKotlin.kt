package week_6.Opdracht8

class PalinDromeKotlin{

    /**
     * Equals without case sensitivity
     */
    fun equals(str: String): Boolean{
        return StringBuilder(str).reverse().toString() == str
    }

    /**
     * Equals with case sensitivity
     */
    fun equalsIgnoreCase(str: String): Boolean{
        return StringBuilder(str).reverse().toString().equals(str,true)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            println(PalinDromeKotlin().equals("pap"))
            println(PalinDromeKotlin().equalsIgnoreCase("Pap"))
        }
    }
}