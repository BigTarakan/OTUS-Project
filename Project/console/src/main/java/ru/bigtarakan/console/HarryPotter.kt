package ru.bigtarakan.console

import kotlin.math.abs

class HarryPotter {
    fun showTheMagic(spellNum: Int?) {
        for (i in 0 until 25) {
            for (j in 0 until 25) {
                print(if (chooseSpell(spellNum)(i, j)) "# " else ". ")
            }
            println()
        }
    }
    
    private fun chooseSpell(num: Int?): (i: Int, j: Int) -> Boolean {
        when (num) {
            1 -> return {i: Int, j: Int -> i < j}
            2 -> return {i: Int, j: Int -> i == j}
            3 -> return {i: Int, j: Int -> i == 24 - j}
            4 -> return {i: Int, j: Int -> i < 30 - j}
            5 -> return {i: Int, j: Int -> i == j / 2}
            6 -> return {i: Int, j: Int -> i < 10 || j < 10}
            7 -> return {i: Int, j: Int -> i > 15 && j > 15}
            8 -> return {i: Int, j: Int -> i * j == 0}
            9 -> return {i: Int, j: Int -> abs(j - i) > 10}
            10 -> return {i: Int, j: Int -> i < j && i > j / 2 - 1}
            11 -> return {i: Int, j: Int -> i == 1 || j == 1 || i == 23 || j == 23}
            12 -> return {i: Int, j: Int -> i*i + j*j <= 20*20}
            13 -> return {i: Int, j: Int -> abs(24 - i - j) < 5}
            19 -> return {i: Int, j: Int -> i == 0 || j == 0 || i == 24 || j == 24}
            20 -> return {i: Int, j: Int -> i % 2 == j % 2 }
            23 -> return {i: Int, j: Int -> i % 3 == -j % 2 }
            24 -> return {i: Int, j: Int -> i == j || i == 24 - j}
            else -> return {_: Int, _: Int -> true}
        }
    }
}