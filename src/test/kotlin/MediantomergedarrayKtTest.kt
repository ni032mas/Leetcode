import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MediantomergedarrayKtTest {
    @Test
    fun `test (1, 3) (2)`() {
        assertEquals(2.0, findMedianSortedArraysBruteForce(arrayOf(1, 3).toIntArray(), arrayOf(2).toIntArray()))
    }

    @Test
    fun `test (1, 2) (3, 4)`() {
        assertEquals(2.5, findMedianSortedArraysBruteForce(arrayOf(1, 2).toIntArray(), arrayOf(3, 4).toIntArray()))
    }

    @Test
    fun `test (1, 2, 3, 7, 8, 9, 10, 16, 17) 7`() {
        assertEquals(9, binarySearch(arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).toIntArray(), 9))
    }
}