package ru.bigtarakan.console.lesson2

import java.math.BigInteger

class T3Power {
    fun iterate(args: Array<String>): String {
        val a = args[0].toDouble()
        val b = args[1].toBigInteger()
        var res = 1.0

        for(i in 0.tbi() .. (b - 1.tbi()))
            res *= a

        return res.toString()
    }

    fun powerTwo(args: Array<String>): String {
        val a = args[0].toDouble()
        val b = args[1].toBigInteger()
        if (b == 0.tbi()) return "1.0"

        var res = a
        var totalPow = 1.tbi()
        while (totalPow < b) {
            if (totalPow * 2.tbi() < b) {
                res *= res
                totalPow *= 2.tbi()
            } else {
                res *= a
                totalPow++
            }
        }

        return res.toString()
    }

    fun powerTwo2(args: Array<String>): String {
        val a = args[0].toDouble()
        val b = args[1].toBigInteger()
        if (b == 0.tbi()) return "1.0"

        var res = 1.0
        var currPow = b
        var p = a
        while (currPow >= 1.tbi()) {
            if (currPow.rem(2.tbi()) == 1.tbi()) res *= p
            currPow /= 2.tbi()
            p *= p
        }

        return res.toString()
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