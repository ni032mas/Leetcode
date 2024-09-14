//Given a string s, return the longest
//palindromic
//
//substring
//in s.
//
//
//
//Example 1:
//
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
//Example 2:
//
//Input: s = "cbbd"
//Output: "bb"
//
//
//Constraints:
//
//1 <= s.length <= 1000
//s consist of only digits and English letters.

fun main() {
    println(longestPalindrome("sdbababfldd"))
    println(longestPalindrome("cbbd"))
}

fun longestPalindrome(s: String): String {
    var maxLength = 0
    var firstIndex = 0
    var lastIndex = 0
    var lastLengthIndex = s.length - 1
    var maybePalindrome = false
    var k = 0
    for (i in s.indices) {
        k = i
        for (j in lastLengthIndex downTo i + 1) {
            when {
                s[k] == s[j] -> {
//                    if (firstIndex > )
                    lastIndex = j
                    continue
                }
                s[i] != s[j] -> {
                    firstIndex++
                    break
                }
            }
        }
    }

    return s.substring(firstIndex, lastIndex)
}