import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task_2KtTest {

    @Test
    fun containsEvenArr() {
        val evenArr = arrayOf(2,4,6,8,10)
        val oddArr = arrayOf(1,3,7,11)
        val mixedArr = arrayOf(1,4,10,7,9)
        assertTrue(containsEvenArr(arrayOf(evenArr,oddArr,mixedArr)))
        assertTrue(containsEvenArr(arrayOf(evenArr,evenArr,evenArr)))
        assertFalse(containsEvenArr(arrayOf(oddArr,mixedArr,mixedArr)))
        assertFalse(containsEvenArr(arrayOf(oddArr,oddArr,oddArr)))
    }
}