package week_6.Opdracht1

class HouseInKotlin{
    fun drawHouse(){
        println("   +  \r\n" +
                "  + + \n" +
                " +   + \n" +
                "+-----+\n" +
                "|  _  |\n" +
                "| | | |\n" +
                "| | | |\n" +
                "|_+_+_|")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            HouseInKotlin().drawHouse();
        }
    }
}