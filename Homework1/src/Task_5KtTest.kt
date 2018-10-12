import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task_5KtTest {

    @Test
    fun isGoodMatrix(){
        val rowWith1Elem = arrayOf<Double>(1.0)
        val rowWith2Elem = arrayOf<Double>(1.0,2.0)
        val rowWith3Elem = arrayOf<Double>(1.0,2.0,3.0)
        val rowWith4Elem = arrayOf<Double>(1.0,2.0,3.0,4.0)
        assertTrue(isGoodMatrix(arrayOf(rowWith1Elem)))
        assertTrue(isGoodMatrix(arrayOf(rowWith2Elem,rowWith2Elem,rowWith2Elem)))
        assertTrue(isGoodMatrix(arrayOf(rowWith3Elem,rowWith3Elem,rowWith3Elem)))
        assertFalse(isGoodMatrix(arrayOf(rowWith2Elem,rowWith3Elem)))
        assertFalse(isGoodMatrix(arrayOf(rowWith4Elem,rowWith4Elem,rowWith3Elem)))
    }

    @Test
    fun matrixComp() {
    }
}