package ru.bigtarakan.console.lesson2

import sun.security.util.BitArray
import kotlin.math.roundToInt
import kotlin.math.sqrt

class T5Primes {
    fun check1(args: Array<String>): String {
        val a = args[0].toInt()
        var count = 0
        for (i in 2 .. a) {
            if (isPrime8(i)) count++
        }
        return count.toString()
    }

    private val pr = mutableListOf<Int>()
    fun check2(args: Array<String>): String {
        val a = args[0].toInt()
        if (a == 1) return "0"
        pr.add(2)
        var count = 1
        for (i in 3 .. a step(2)) {
            if (isPrime9(i)) {
                count++
                pr.add(i)
            }
        }
        return count.toString()
    }

    private fun isPrime1(p: Int): Boolean {
        var count = 0
        for (i in 1 .. p) {
            if (p % i == 0) count++
        }
        return count == 2
    }

    private fun isPrime2(p: Int): Boolean {
        for (i in 2 until p) {
            if (p % i == 0) return false
        }
        return true
    }

    private fun isPrime3(p: Int): Boolean {
        for (i in 2 .. p/2) {
            if (p % i == 0) return false
        }
        return true
    }

    private fun isPrime4(p: Int): Boolean {
        for (i in 2 .. sqrt(p.toDouble()).roundToInt()) {
            if (p % i == 0) return false
        }
        return true
    }

    private fun isPrime5(p: Int): Boolean {
        var i = 2
        while (i*i <= p) {
            if (p % i == 0) return false
            i++
        }
        return true
    }

    private fun isPrime6(p: Int): Boolean {
        val a = sqrt(p.toDouble()).roundToInt()
        for (i in 2 .. a) {
            if (p % i == 0) return false
        }
        return true
    }

    private fun isPrime7(p: Int): Boolean {
        if (p == 2) return true
        if (p % 2 == 0) return false
        val a = sqrt(p.toDouble()).roundToInt()
        for (i in 3 .. a step 2) {
            if (p % i == 0) return false
        }
        return true
    }

    private fun isPrime8(p: Int): Boolean {
        if (p == 2) return true
        if (p == 3) return true
        if (p % 2 == 0) return false
        if (p % 3 == 0) return false
        val a = sqrt(p.toDouble()).roundToInt()
        for (i in 5 .. a step 6) {
            if (p % i == 0) return false
            if (p % (i + 2) == 0) return false
        }
        return true
    }

    private fun isPrime9(p: Int): Boolean {
        val a = sqrt(p.toDouble()).roundToInt()
//        var i = 0
//        while (pr[i] <= a) {
//            if (p % pr[i] == 0) return false
//            i++
//        }
        for (i in 0 until pr.size) {
            if (p % pr[i] == 0) return false
            if (pr[i] > a) break
        }
        return true
    }

    fun checkErato(args: Array<String>): String {
        val a = args[0].toInt()
        val divs = Array(a+1) {false}
        var count = 0
        for (i in 2 .. a) {
            if (!(divs[i])) {
                count++
                for (j in i*i .. a step i) {
                    if (j in 0..a)
                        divs[j] = true
                }
            }
        }
        return count.toString()
    }

    fun checkErato2(args: Array<String>): String {
        val a = args[0].toInt()
        val divs = BitArray(a+1)
        var count = 0
        for (i in 2 .. a) {
            if (!(divs[i])) {
                count++
                for (j in i*i .. a step i) {
                    if (j in 0..a)
                        divs[j] = true
                }
            }
        }
        return count.toString()
    }

    fun checkErato3(args: Array<String>): String {
        val n = args[0].toInt()
        if (n < 2) return "0"
        val pr = arrayListOf<Int>()
        val lp = arrayListOf<Int>()
        for (i in 0 .. n) lp.add(0)
        for (i in 2 .. n) {
            if(lp[i] == 0) {
                lp[i] = i
                pr.add(i)
            }
            pr.forEach { p ->
                if (p <= lp[i] && p*i in 0 .. n) lp[p*i] = p
            }
        }
        return pr.size.toString()
    }
}