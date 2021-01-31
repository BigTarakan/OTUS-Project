package ru.bigtarakan.console.lesson1

import java.math.BigInteger
import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class T1Tickets {
    fun calcMethod2(args: Array<String>): String { // рекурсия
        val num = args[0].toInt()
        var count = 0

        fun getNext(nr: Int, s1: Int, s2: Int) {
            if (nr == num*2) {
                if (s1 == s2) count++
                return
            }
            for (i in 0..9) {
                if (nr < num) getNext(nr + 1, s1 + i, s2)
                else getNext(nr + 1, s1, s2 + i)
            }
        }

        getNext(0, 0, 0)
        return count.toString()
    }

    fun calcMethod1(args: Array<String>): String { //перебор
        val num = args[0].toInt()
        var count = 0
        var curr = 0
        do {
            if (isHappy(curr, num)) count++
            curr++
            println(curr)
        } while (curr.toString().length <= num*2)


        return count.toString()
    }

    private fun isHappy(n: Int, num: Int): Boolean {
        val stringN = n.toString().fillWithNothing(num*2)
        //if (n == 0) return true
        //if (stringN.length <= num) return false
        val sum1 = calcSum(stringN.substring(0, stringN.length - num))
        val sum2 = calcSum(stringN.substring(stringN.length - num, stringN.length))

        return sum1 == sum2
    }

    private fun String.fillWithNothing(num: Int): String{
        var res = this
        while (res.length < num) {
            res = "0$res"
        }
        return res
    }

    private fun calcSum(s: String): Int {
        var sum = 0
        s.forEach { sum+=it.toInt() }
        return sum
    }

    fun calcMethod3(args: Array<String>): String { //формула из интернета, метод производящей функции
        val num = args[0].toInt()
        var sum = 0.toBigInteger()
        for (i in 0..(9*num/10)) {
            sum += (-1).toBigInteger().pow(i) * c(2 * num, i) * c((11 * num - 10 * i - 1), (9 * num - 10 * i))
        }
        return sum.toString()
    }

    private fun c(n: Int, k:Int): BigInteger {
        return (n.toBigInteger().fact() / ((n-k).toBigInteger().fact() * k.toBigInteger().fact()))
    }

    private fun BigInteger.fact(): BigInteger {
        var res = 1.toBigInteger()
        for (i in 1..this.toInt()) {
            res *= i.toBigInteger()
        }
        return res
    }
}