import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Test_3KtTest {

    @Test
    fun getAmicables() {
        val amicables1 = Pair(220,284)
        val amicables2 = Pair(1184, 1210)
        val amicables3 = Pair(2620, 2924)
        val amicables4 = Pair(5020, 5564)
        val amicables5 = Pair(6232, 6368)
        val testArr1 = arrayOf(amicables1, amicables2, Pair(2,123))
        val testArr2 = arrayOf(amicables1, Pair(129,267), amicables4, Pair(2,123))
        val testArr3 = arrayOf(amicables1, amicables5, Pair(2,1))
        val testArr4 = arrayOf(amicables1,Pair(123,34253), Pair(234,124), amicables2, amicables3, Pair(2,123))
        val testArr5 = arrayOf(Pair(2,123), Pair(123,34253), Pair(234,124))

        assertEquals(listOf(amicables1,amicables2),getAmicables(testArr1))
        assertEquals(listOf(amicables1,amicables4),getAmicables(testArr2))
        assertEquals(listOf(amicables1,amicables5),getAmicables(testArr3))
        assertEquals(listOf(amicables1,amicables2, amicables3),getAmicables(testArr4))
        assertEquals(listOf<Pair<Int,Int>>(),getAmicables(testArr5))
    }
}