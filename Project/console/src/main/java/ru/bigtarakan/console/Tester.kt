package ru.bigtarakan.console

import ru.bigtarakan.console.lesson1.T0String
import java.io.File

class Tester {
    fun runTests(func: (args: Array<String>) -> String, testsFolder: String): Boolean {
        var testNum = 0
        var success = true

        do {
            try {
                val inList = File("Tests/$testsFolder/test.$testNum.in").readLines()
                val outList = File("Tests/$testsFolder/test.$testNum.out").readLines()

                val a = func(arrayOf(inList[0]))
                val b = outList[0]
                val result = a == b
                if (!result) success = false

                println("Test $testNum ${if (result) "passed" else "failed"}")
                testNum++
            } catch (e: Exception) { break }
        } while (true)

        println()
        if (testNum == 0) {
            println("Test init error")
            return false
        } else println("Testing ${if (success) "completed successfully" else "FAILED"}")

        return success
    }
}