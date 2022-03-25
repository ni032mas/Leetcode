package twosum

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TwosumKtTest {

    private val nums = intArrayOf(6, 2, 3, 4, 5, 9, 7, 8)

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
        val result = intArrayOf(0, 6)
        assertArrayEquals(result, twoSum(nums, target))
    }

    @Test
    fun `test two sum target 6`() {
        val target = 6
        val result = intArrayOf(1, 2)
        assertArrayEquals(result, twoSum(intArrayOf(3, 2, 4), target))
    }
}