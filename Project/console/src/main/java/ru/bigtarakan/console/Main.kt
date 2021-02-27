package ru.bigtarakan.console

import ru.bigtarakan.console.lesson3.T0Bits

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        //HarryPotter().showTheMagic(19)
        //println(T0String().calcLength(arrayOf("test")))
        //Tester().runTests({fArgs -> T0String().calcLength(fArgs)},"0.String")
        //println(T1Tickets().calcMethod3(arrayOf(3.toString())))
        //Tester().runTests({fArgs -> T1Tickets().calcMethod3(fArgs)},"1.Tickets")

        //println(T3Power().powerTwo2(arrayOf("1.000001", "1000000")))
        //Tester().runTests({fArgs -> T3Power().powerTwo2(fArgs)}, "3.Power")
        //println(T4Fibo().matrixPow(arrayOf("18")))
        //Tester().runTests({fArgs -> T4Fibo().matrixPow(fArgs)}, "4.Fibo")
        //println(T5Primes().checkErato3(arrayOf("10")))
        //Tester().runTests({fArgs -> T5Primes().checkErato3(fArgs)}, "5.Primes")

        //T0Bits().rook(arrayOf("0")).forEach { println(it) }
        //Tester().runTestsMultiline({fArgs -> T0Bits().king(fArgs)}, "6.Bitboard-King")
        //Tester().runTestsMultiline({fArgs -> T0Bits().knight(fArgs)}, "6.Bitboard-Knight")
        //Tester().runTestsMultiline({fArgs -> T0Bits().bishop(fArgs)}, "6.Bitboard-Bishop")
//        Tester().runTestsMultiline({fArgs -> T0Bits().rook(fArgs)}, "6.Bitboard-Rook")
        Tester().runTestsMultiline({fArgs -> T0Bits().queen(fArgs)}, "6.Bitboard-Queen")
    }
}