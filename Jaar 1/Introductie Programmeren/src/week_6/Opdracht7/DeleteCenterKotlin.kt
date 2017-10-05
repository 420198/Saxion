package week_6.Opdracht7

import java.util.*

class DeleteCenterKotlin{

    private fun run() {
        println(Arrays.toString(deleteCenter(3, 2, 6, 1, 0)))
        println(Arrays.toString(deleteCenter(3, 2, 6, 1, 2, 0)))
    }

    private fun deleteCenter(vararg nums: Int): IntArray {
        val arr: IntArray
        var j = 0
        if (nums.size % 2 == 0) {
            nums[nums.size / 2 - 1] = 0
            arr = IntArray(nums.size - 2)
        } else {
            arr = IntArray(nums.size - 1)
        }
        nums[nums.size / 2] = 0

        nums.filter { it != 0 }.forEach { arr[j++] = it }
        return arr
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            DeleteCenterKotlin().run()
        }
    }
}