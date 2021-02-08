package ru.bigtarakan.console

import ru.bigtarakan.console.lesson2.T5Primes

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
        Tester().runTests({fArgs -> T5Primes().checkErato3(fArgs)}, "5.Primes")
    }
}