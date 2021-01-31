package ru.bigtarakan.console

import ru.bigtarakan.console.lesson1.T1Tickets

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        //HarryPotter().showTheMagic(19)//
        //println(T0String().calcLength(arrayOf("test")))
        //Tester().runTests({fArgs -> T0String().calcLength(fArgs)},"0.String")
        //println(T1Tickets().calcMethod3(arrayOf(3.toString())))
        Tester().runTests({fArgs -> T1Tickets().calcMethod3(fArgs)},"1.Tickets")
    }
}