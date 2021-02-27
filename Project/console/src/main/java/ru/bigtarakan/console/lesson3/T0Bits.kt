package ru.bigtarakan.console.lesson3

@ExperimentalUnsignedTypes
class T0Bits {
    fun king(args: Array<String>): Array<String> {
        val x = args[0].toInt()
        val notA = 0xfefefefefefefefeuL
        val notH = 0x7f7f7f7f7f7f7f7fuL
        val k = 1uL shl x
        val ka = notA and k
        val kh = notH and k
        val m = (ka shl 7) or (k shl 8) or (kh shl 9) or
                (ka shr 1) or              (kh shl 1) or
                (ka shr 9) or (k shr 8) or (kh shr 7)
        return arrayOf(popcnt2(m).toString(), m.toString())
    }

    fun knight(args: Array<String>): Array<String> {
        val x = args[0].toInt()
        val notLeft1 = 0xfefefefefefefefeuL
        val notLeft2 = 0xfcfcfcfcfcfcfcfcuL
        val notRight1 = 0x7f7f7f7f7f7f7f7fuL
        val notRight2 = 0x3f3f3f3f3f3f3f3fuL
        val k = 1uL shl x
        val kl1 = notLeft1 and k
        val kl2 = notLeft2 and k
        val kr1 = notRight1 and k
        val kr2 = notRight2 and k
        val m =         (kl1 shl 15) or (kr1 shl 17) or
                (kl2 shl 6) or                (kr2 shl 10) or
                (kl2 shr 10) or                (kr2 shr 6) or
                        (kl1 shr 17) or (kr1 shr 15)
        return arrayOf(popcnt2(m).toString(), m.toString())
    }

    fun bishop(args: Array<String>): Array<String> {
        val x = args[0].toInt()
        val notLeft = getRightMask(x)
        val notRight = getLeftMask(x)
        val k = 1uL shl x
        val m = (((k shl 9) or (k shl 18) or (k shl 27) or (k shl 36) or (k shl 45) or (k shl 54) or (k shl 63)) and notLeft) or //право верх
                (((k shr 7) or (k shr 14) or (k shr 21) or (k shr 28) or (k shr 35) or (k shr 42) or (k shr 49)) and notLeft) or //право низ
                (((k shr 9) or (k shr 18) or (k shr 27) or (k shr 36) or (k shr 45) or (k shr 54) or (k shr 63)) and notRight) or //лево низ
                (((k shl 7) or (k shl 14) or (k shl 21) or (k shl 28) or (k shl 35) or (k shl 42) or (k shl 49)) and notRight) //лево верх
        return arrayOf(popcnt2(m).toString(), m.toString())
    }

    fun rook(args: Array<String>): Array<String> {
        val x = args[0].toInt()
        val notLeft = getRightMask(x)
        val notRight = getLeftMask(x)
        val k = 1uL shl x
        val m = (((k shl 1) or (k shl 2) or (k shl 3) or (k shl 4) or (k shl 5) or (k shl 6) or (k shl 7)) and notLeft) or //право
                (((k shr 1) or (k shr 2) or (k shr 3) or (k shr 4) or (k shr 5) or (k shr 6) or (k shr 7)) and notRight) or //лево
                ((k shr 8) or (k shr 16) or (k shr 24) or (k shr 32) or (k shr 40) or (k shr 48) or (k shr 56)) or //низ
                ((k shl 8) or (k shl 16) or (k shl 24) or (k shl 32) or (k shl 40) or (k shl 48) or (k shl 56)) //верх
        return arrayOf(popcnt2(m).toString(), m.toString())
    }

    fun queen(args: Array<String>): Array<String> {
        val x = args[0].toInt()
        val notLeft = getRightMask(x)
        val notRight = getLeftMask(x)
        val k = 1uL shl x
        val m = (((k shl 9) or (k shl 18) or (k shl 27) or (k shl 36) or (k shl 45) or (k shl 54) or (k shl 63)) and notLeft) or //право верх
                (((k shr 7) or (k shr 14) or (k shr 21) or (k shr 28) or (k shr 35) or (k shr 42) or (k shr 49)) and notLeft) or //право низ
                (((k shr 9) or (k shr 18) or (k shr 27) or (k shr 36) or (k shr 45) or (k shr 54) or (k shr 63)) and notRight) or //лево низ
                (((k shl 7) or (k shl 14) or (k shl 21) or (k shl 28) or (k shl 35) or (k shl 42) or (k shl 49)) and notRight) or //лево верх
                (((k shl 1) or (k shl 2) or (k shl 3) or (k shl 4) or (k shl 5) or (k shl 6) or (k shl 7)) and notLeft) or //право
                (((k shr 1) or (k shr 2) or (k shr 3) or (k shr 4) or (k shr 5) or (k shr 6) or (k shr 7)) and notRight) or //лево
                ((k shr 8) or (k shr 16) or (k shr 24) or (k shr 32) or (k shr 40) or (k shr 48) or (k shr 56)) or //низ
                ((k shl 8) or (k shl 16) or (k shl 24) or (k shl 32) or (k shl 40) or (k shl 48) or (k shl 56)) //верх
        return arrayOf(popcnt2(m).toString(), m.toString())
    }

    private fun getRightMask(x: Int): ULong {
        var result = 0uL
        val w = 7 - (x % 8)
        val h1 = (x / 8)
        val h2 = (x / 8) - 7
        for (j in h2 .. h1) {
            for (i in 1..w) {
                result = result or (1uL shl (x + i - 8 * j))
            }
        }
        return result
    }

    private fun getLeftMask(x: Int): ULong {
        var result = 0uL
        val w = x % 8
        val h1 = (x / 8)
        val h2 = (x / 8) - 7
        for (j in h2 .. h1) {
            for (i in 1..w) {
                result = result or (1uL shl (x - i - 8 * j))
            }
        }
        return result
    }

    fun popcnt(data: ULong): Int {
        var cnt = 0
        var bits = data
        while (bits > 0uL) {
            if ((bits and 1uL) == 1uL)
                cnt++
            bits = bits shr 1
        }
        return cnt
    }

    fun popcnt2(data: ULong): Int {
        var cnt = 0
        var bits = data
        while (bits > 0uL) {
            cnt++
            bits = bits and (bits - 1uL)
        }
        return cnt
    }
}