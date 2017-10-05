package week_6.Opdracht6

class AverageKotlin{
    private fun average(vararg nums: Double) {
        println("Average: " + nums.average())
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            AverageKotlin().average(6.0,1.0,2.0,6.0,8.0,9.0,12.0,13.0)
            AverageKotlin().average(6.0,1.0,2.0,6.0,8.0,9.0,12.0,3.0)
        }
    }
}