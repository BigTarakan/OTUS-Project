package ru.bigtarakan.console

import java.io.File

class Tester {
    fun runTests(func: (args: Array<String>) -> String, testsFolder: String): Boolean {
        var testNum = 0
        var success = true

        do {
            try {
                val inList = File("Tests/$testsFolder/test.$testNum.in").readLines()
                val outList = File("Tests/$testsFolder/test.$testNum.out").readLines()

                val t1 = System.nanoTime()
                val a = func(inList.toTypedArray())
                val t2 = System.nanoTime()
                val b = outList[0]
                val result = when {
                    a == b -> 1
                    b.startsWith(a) -> 2
                    a.startsWith(b) -> 3
                    b.length > 9 && a.length > 9 && b.subSequence(0,9) == a.subSequence(0,9) -> 4
                    else -> -1
                }
                if (result < 0) success = false

                val time = (t2-t1)/1000000
                //println("Test $testNum ${if (result == 1) "passed ($a)" else if (result > 1) "~passed($a - $b)" else "failed($a - $b)"} in ${time}ms")
                println("${if (result == 1) "passed" else if (result > 1) "~passed" else "failed"} in ${time}ms")
                //println("Test $testNum ${if (result == 1) "passed" else if (result > 1) "~passed" else "failed"} in ${time}ms")
                if (time > 60000) {
                    println("too long, interrupting")
                    break
                }
                testNum++
            } catch (e: Exception) {
                //e.printStackTrace()
                break
            }
        } while (true)

        println()
        if (testNum == 0) {
            println("Test init error")
            return false
        } else println("Testing ${if (success) "completed successfully" else "FAILED"}")

        return success
    }
}