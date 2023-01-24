package longestsubstringwithoutrepeating

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class LongestsubstringwithoutrepeatingKtTest {
    @Test
    fun `test is string abcabcbb`() {
        assertEquals(3, logestSubstring("abcabcbb"))
    }

    @Test
    fun `test is string bbbbb`() {
        assertEquals(1, logestSubstring("bbbbb"))
    }

    @Test
    fun `test is string pwwkew`() {
        assertEquals(3, logestSubstring("pwwkew"))
    }

    @Test
    fun `test is string aab`() {
        assertEquals(2, logestSubstring("aab"))
    }

    @Test
    fun `test is string dvdf`() {
        assertEquals(3, logestSubstring("dvdf"))
    }

    @Test
    fun `test is string dvcdfu`() {
        assertEquals(5, logestSubstring("dvcdfu"))
    }

    @Test
    fun `test is string hash set dvcdfu`() {
        assertEquals(5, lengthOfLongestSubstring("dvcdfu"))
    }
}