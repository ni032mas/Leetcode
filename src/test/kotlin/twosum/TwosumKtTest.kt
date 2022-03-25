package twosum

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TwosumKtTest {

    private val nums = intArrayOf(6, 2, 3, 4, 4, 9, 2, 9)

    @Test
    fun `test two sum target 8`() {
        val target = 8
        val result = intArrayOf(0, 1)
        assertArrayEquals(result, twoSum(nums, target))
    }

    @Test
    fun `test two sum target 5`() {
        val target = 5
        val result = intArrayOf(1, 2)
        assertArrayEquals(result, twoSum(nums, target))
    }

    @Test
    fun `test two sum target 13`() {
        val target = 13
        val result = intArrayOf(3, 5)
        assertArrayEquals(result, twoSum(nums, target))
    }
}