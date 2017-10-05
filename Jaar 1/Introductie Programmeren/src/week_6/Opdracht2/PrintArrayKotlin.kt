package week_6.Opdracht2

class PrintArrayKotlin {
    fun printArray(arr: DoubleArray) {
        for (i in 0 until arr.size) {
            println(arr[i].toString())
        }
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val arr = DoubleArray(4)
            arr[0] = 2.5
            arr[1] = 1.5
            arr[2] = 3.5
            arr[3] = 4.5
            PrintArrayKotlin().printArray(arr)
        }
    }
}