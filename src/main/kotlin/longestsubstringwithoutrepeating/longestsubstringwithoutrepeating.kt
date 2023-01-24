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
        if (hashMap.getOrDefault(char, 0) > prev) {
            prev = hashMap.getOrDefault(char, 0)
        }
        if (longestSubstringSize < index - prev) {
            longestSubstringSize = index - prev
        }
        hashMap[char] = index
    }
    return longestSubstringSize
}

fun lengthOfLongestSubstring(s: String): Int {
    val characters = HashSet<Char>()

    var firstPointer = 0;
    var secondPointer = 0;

    var maxLength = 0;
    var currentLength = 0;

    while(secondPointer < s.length) {
        val current = s[secondPointer]
        if(!characters.contains(current)) {
            characters.add(current);
            secondPointer++
            currentLength++
            if(currentLength > maxLength) {
                maxLength = currentLength
            }
        } else {
            characters.remove(s[firstPointer])
            firstPointer++
            currentLength--
        }
    }

    return maxLength;

}

