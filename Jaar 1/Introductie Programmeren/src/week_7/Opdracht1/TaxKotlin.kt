package week_7.Opdracht1

import week_7.Opdracht1.Model.Tax
import java.util.*

class TaxKotlin {
    private val tax = arrayOfNulls<Tax>(4)
    private val s = Scanner(System.`in`)
    private var salary: Int = 0
    private var totalTax: Int = 0

    private fun run() {
        print("Voer uw loon in: ")
        salary = s.nextInt()
        tax[0] = Tax(0.5200, 67073)
        tax[1] = Tax(0.4080, 33792)
        tax[2] = Tax(0.4080, 19983)
        tax[3] = Tax(0.3655, 0)
        var i = 0
        var j = tax.size
        while (i < tax.size) {
            if (salary < tax[i]!!.tax) {
                println("Schijf " + j-- + ": " + tax[i]!!.taxPercentage * 100 + " over 0 = 0")
            } else {
                val myTax = ((salary - tax[i]!!.tax) * tax[i]!!.taxPercentage).toInt()
                totalTax += myTax
                println("Schijf " + j-- + ": " + 100 * tax[i]!!.taxPercentage + " over " + (salary - tax[i]!!.tax) + " = " + myTax)
                salary -= salary - tax[i]!!.tax
            }
            i++
        }
        println("Totaal: " + totalTax)
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            TaxKotlin().run()
        }
    }
}
