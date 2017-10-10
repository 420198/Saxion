package week_7.Opdracht5

import java.util.*

class MemoryPair {
    private val memoryPairs = intArrayOf(1, 1, 2, 2, 3, 3, 4, 4)
    private val answer = arrayOf(".", ".", ".", ".", ".", ".", ".", ".")
    private var n1: Int = 0
    private var n2: Int = 0
    private val s = Scanner(System.`in`)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            MemoryPair().run()
        }
    }


    private fun run() {
        shuffle(memoryPairs)
        print("Please enter index 1: ")
        n1 = s.nextInt()
        print("Please enter index 2: ")
        n2 = s.nextInt()

        do {
            if (checkCorrect(n1, n2)) {
                println("Yeah! You found a pair")
                println(Arrays.toString(answer))
                if (finished()) break
            } else {
                println("No, $n1 and $n2 is not a memory pair... (passive agressiveness intensifies)")
                answer[n1] = memoryPairs[n1].toString()
                answer[n2] = memoryPairs[n2].toString()
                println(Arrays.toString(answer))
                answer[n2] = "."
                answer[n1] = answer[n2]
            }

            print("Please enter index 1: ")
            n1 = s.nextInt()
            print("Please enter index 2: ")
            n2 = s.nextInt()
        } while (!finished())
    }

    /**
     * Finished check
     * @return finished
     */
    private fun finished(): Boolean {
        return answer[0] != "." && answer[1] != "." && answer[2] != "." && answer[3] != "." &&
                answer[4] != "." && answer[5] != "." && answer[6] != "." && answer[7] != "."
    }

    /**
     * Shuffling
     *
     * @param pairs array
     */
    private fun shuffle(pairs: IntArray) {
        var index: Int
        var temp: Int
        val random = Random()
        for (i in pairs.size - 1 downTo 1) {
            index = random.nextInt(i + 1)
            temp = pairs[index]
            pairs[index] = pairs[i]
            pairs[i] = temp
        }
    }

    /**
     * Check if equals
     *
     * @param n1 number one
     * @param n2 number two
     * @return equals
     */
    private fun checkCorrect(n1: Int, n2: Int): Boolean {
        if (memoryPairs[n1] == memoryPairs[n2]) {
            answer[n2] = "(" + memoryPairs[n1] + ")"
            answer[n1] = answer[n2]
            return true
        }
        return false
    }
}