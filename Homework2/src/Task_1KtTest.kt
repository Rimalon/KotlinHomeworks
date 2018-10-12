import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task_1KtTest {

    @Test
    fun countNeededElems() {
        val testArr0 = arrayOf(13)
        val testArr1 = arrayOf(1,2,3,4,5)
        val testArr2 = arrayOf(1,10,120,43,35,100,150)
        val testArr3 = arrayOf(23,20,21,1,2,5,150,600)
        val testArr4 = arrayOf(2,123,100,123,123,123,100,2,2,2)
        val testArr5 = arrayOf(2,123,100,123,2)
        val testArr6 = arrayOf(2,2,2,2,2,2,2,2,2,2)
        val testArr7 = arrayOf(100,100,100,100)
        val testArr8 = arrayOf(1,1,1,3,3,100)
        val testArr9 = arrayOf(120,120,120,120,120,120,120,2,3,4)
        val testArr10 = arrayOf(2,2,2,10,10)
        val testArr11 = arrayOf(2,2,2,10,10,10)
        assertEquals(1,countNeededElems(testArr0))
        assertEquals(3,countNeededElems(testArr1))
        assertEquals(2,countNeededElems(testArr2))
        assertEquals(4,countNeededElems(testArr3))
        assertEquals(2,countNeededElems(testArr4))
        assertEquals(1,countNeededElems(testArr5))
        assertEquals(1,countNeededElems(testArr6))
        assertEquals(0,countNeededElems(testArr7))
        assertEquals(1,countNeededElems(testArr8))
        assertEquals(3,countNeededElems(testArr9))
        assertEquals(0,countNeededElems(testArr10))
        assertEquals(1,countNeededElems(testArr11))
    }
}