package ru.bigtarakan.console.lesson2

import java.math.BigInteger
import kotlin.math.sqrt

class T4Fibo {
    fun recursion(args: Array<String>): String {
        val a = args[0].toBigInteger()
        return getRecurItem(a).toString()
    }

    private fun getRecurItem(num : BigInteger): BigInteger =
        when (num) {
            0.tbi() -> 0.tbi()
            1.tbi() -> 1.tbi()
            else -> getRecurItem(num - 2.tbi()) + getRecurItem(num - 1.tbi())
        }

    fun iterate(args: Array<String>): String {
        val a = args[0].toBigInteger()
        var a0 = 0.tbi()
        var a1 = 1.tbi()
        var a2 = 0.tbi()
        when (a) {
            0.tbi() -> return a0.toString()
            1.tbi() -> return a1.toString()
        }

        for (i in 1.tbi()..a) {
            a0 = a1
            a1 = a2
            a2 = a0 + a1
        }

        return a2.toString()
    }

    fun golden(args: Array<String>): String {
        val a = args[0].toInt()
        val fi = ((1 + sqrt(5.0)) / 2).toBigDecimal()
        val res = fi.pow(a)/ sqrt(5.0).toBigDecimal() + 0.5.toBigDecimal()

        return res.toString()
    }

    fun matrixPow(args: Array<String>): String {
        val a = args[0].toBigInteger()
        if (a < 2.tbi()) return a.toString()
        var res = Matrix().start()
        var currPow = a - 1.tbi()
        var p = Matrix()
        while (currPow >= 1.tbi()) {
            if (currPow.rem(2.tbi()) == 1.tbi())
                res = res.multiply(p)
            currPow /= 2.tbi()
            p = p.multiplySelf()
        }
        return res.a11.toString()
    }

    inner class Matrix {
        var a11: BigInteger = 1.tbi()    //a11 a12
        var a12: BigInteger = 1.tbi()    //a21 a22
        var a21: BigInteger = 1.tbi()
        var a22: BigInteger = 0.tbi()

        fun start(): Matrix {
            val result = Matrix()
            result.a11 = 1.tbi()
            result.a12 = 0.tbi()
            result.a21 = 0.tbi()
            result.a22 = 1.tbi()
            return result
        }

        fun multiply(b: Matrix): Matrix {
            val rM = Matrix()
            rM.a11 = a11*b.a11 + a12*b.a21
            rM.a12 = a11*b.a12 + a12*b.a22
            rM.a21 = a21*b.a11 + a22*b.a21
            rM.a22 = a21*b.a12 + a22*b.a22
            return rM
        }

        fun multiplySelf(): Matrix = multiply(this)
    }


    //Some system classes
    operator fun BigInteger.rangeTo(other: BigInteger) =
            BigIntegerRange(this, other)

    class BigIntegerRange(
            override val start: BigInteger,
            override val endInclusive: BigInteger
    ) : ClosedRange<BigInteger>, Iterable<BigInteger> {
        override operator fun iterator(): Iterator<BigInteger> =
                BigIntegerRangeIterator(this)
    }

    class BigIntegerRangeIterator(
            private val range: ClosedRange<BigInteger>
    ) : Iterator<BigInteger> {
        private var current = range.start

        override fun hasNext(): Boolean =
                current <= range.endInclusive

        override fun next(): BigInteger {
            if (!hasNext()) {
                throw NoSuchElementException()
            }
            return current++
        }
    }

    fun Int.tbi() = this.toBigInteger() //shorter
}