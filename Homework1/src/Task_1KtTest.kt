import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Task_1KtTest {

    @Test
    fun isPossibleToReach() {
        assertFalse(isPossibleToReach(-5))
        assertFalse(isPossibleToReach(0))
        assertFalse(isPossibleToReach(1))
        assertFalse(isPossibleToReach(2))
        assertFalse(isPossibleToReach(3))
        assertFalse(isPossibleToReach(4))
        assertFalse(isPossibleToReach(5))
        assertFalse(isPossibleToReach(7))
        assertFalse(isPossibleToReach(9))
        assertFalse(isPossibleToReach(11))
        assertTrue(isPossibleToReach(6))
        assertTrue(isPossibleToReach(8))
        assertTrue(isPossibleToReach(10))
        assertTrue(isPossibleToReach(12))
        assertTrue(isPossibleToReach(14))
    }
}