package palindromenumber

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PalindromeKtTest {

    @Test
    fun `test is palindrome 121`() {
        assertEquals(true, isPalindrome(121))
    }

    @Test
    fun `test is palindrome 1211`() {
        assertEquals(false, isPalindrome(1211))
    }

    @Test
    fun `test is palindrome -121`() {
        assertEquals(false, isPalindrome(-121))
    }
}