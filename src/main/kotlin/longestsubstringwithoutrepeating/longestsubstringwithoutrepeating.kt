package longestsubstringwithoutrepeating

// Given a string s, find the length of the longest
// substring without repeating characters.

fun main() {
    val str = "bbbbb"

}

fun logestSubstring(s: String): Int {
    val hashMap = hashMapOf<Char, Int>()
    var longestSubstringSize = 0
    var prev = 0
    s.forEachIndexed { index, char ->
        prev = if (hashMap.getOrDefault(char, 0) > prev) {
            hashMap.getOrDefault(char, 0)
        } else {
            prev
        }
        longestSubstringSize = if (longestSubstringSize > index - prev) {
            longestSubstringSize
        } else {
            index - prev
        }
        hashMap[char] = index
    }
    return longestSubstringSize
}

