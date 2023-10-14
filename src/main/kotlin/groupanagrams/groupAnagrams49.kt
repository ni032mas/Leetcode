package groupanagrams


//49. Group Anagrams
//
//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//
//
//Example 1:
//
//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//Example 2:
//
//Input: strs = [""]
//Output: [[""]]
//Example 3:
//
//Input: strs = ["a"]
//Output: [["a"]]
//
//
//Constraints:
//
//1 <= strs.length <= 104
//0 <= strs[i].length <= 100
//strs[i] consists of lowercase English letters.

fun groupAnagramsInt(strs: Array<String>): List<List<String>> {
    val hashmap = HashMap<String, Int>()
    val result = mutableListOf<MutableList<String>>()
    for (str in strs) {
        val charArray = str.toCharArray()
        charArray.sort()
        val sortedStr = String(charArray)

        if (hashmap.containsKey(sortedStr)) {
            hashmap[sortedStr]?.let { index -> result[index].add(str) }
        } else {
            result.add(mutableListOf(str))
            hashmap[sortedStr] = result.size - 1
        }
    }

    return result.map { it.sorted() }
}

fun main() {
    val strs0 = arrayOf("mod", "axe", "", "b")
    println(groupAnagrams(strs0))
    // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    val strs1 = arrayOf("", "eat", "tea", "tan", "ate", "nat", "bat")
    println(groupAnagrams(strs1))
    // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    val strs2 = arrayOf("")
    println(groupAnagrams(strs2))
    // Output: [[""]]

    val strs3 = arrayOf("a")
    println(groupAnagrams(strs3))
    // Output: [["a"]]
    //
    val strs4 = arrayOf("cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc")
    println(groupAnagrams(strs4))
    // Output: [["a"]]
}

fun groupAnagramsCategorizeByFrequency(strs: Array<String>): List<List<String>> {

    if (strs.isEmpty()) return mutableListOf()
    val frequencyStringsMap = HashMap<String, MutableList<String>>()
    for (str in strs) {
        val frequencyString = getFrequencyString(str)
        if (frequencyStringsMap.containsKey(frequencyString)) {
            frequencyStringsMap[frequencyString]?.add(str)
        } else {
            frequencyStringsMap[frequencyString] = mutableListOf(str)
        }
    }
    return frequencyStringsMap.values.toList()
}

private fun getFrequencyString(str: String): String {

    // Frequency buckets
    val freq = IntArray(26)

    // Iterate over each character
    for (c in str.toCharArray()) {
        freq[c.code - 'a'.code]++
    }

    // Start creating the frequency string
    val frequencyString = StringBuilder("")
    var c = 'a'
    for (i in freq) {
        frequencyString.append(c)
        frequencyString.append(i)
        c++
    }
    return frequencyString.toString()
}

fun groupAnagrams(strs: Array<String>): List<List<String>> =
    strs.fold(HashMap<Int, MutableList<String>>()) { result, str ->
        str.fold(CharArray(26)) { symbolArray, b ->
            symbolArray[b.code - 'a'.code]++
            symbolArray
        }.let { symbolArray ->
            result.getOrPut(symbolArray.contentHashCode()) { mutableListOf() }.add(str)
            result
        }
    }.values.toList()

fun groupAnagramsFunVersion2(strs: Array<String>): List<List<String>> =
    strs.fold(HashMap<Int, MutableList<String>>()) { result, str ->
        str.toSet().let { set ->
            set.fold(0) { a, b -> a + b.code }.let { hash ->
                result[hash]?.add(str) ?: run { result[hash] = mutableListOf(str) }
                result
            }
        }
    }.values.toList()

//fun groupAnagramsFunVersionSet(strs: Array<String>): List<List<String>> =
//    strs.fold(HashMap<Set<Int>, MutableList<String>>()) { result, str ->
//        str.toSet().let { set ->
//            if (set.size == str.length && str.any { set.contains(it).not() }.not()) {
//
//            } else {
//
//            }
//        }
//        str.toSet().fold(0) { a, b -> a + b.code }.let { set ->
//            set
//            result[hash]?.add(str) ?: run { result[hash] = mutableListOf(str) }
//            result
//        }
//    }.values.toList()

private fun getFrequencyString1(str: String): String {

    // Frequency buckets
    val freq = IntArray(26)

    str.toCharArray().fold(0) { a, b -> a + b.code }

    // Iterate over each character
    for (c in str.toCharArray()) {
        freq[c.code - 'a'.code]++
    }

    // Start creating the frequency string
    val frequencyString = StringBuilder("")
    var c = 'a'
    for (i in freq) {
        frequencyString.append(c)
        frequencyString.append(i)
        c++
    }
    return frequencyString.toString()
}

fun groupAnagramsSorted(strs: Array<String>): List<List<String>> {
    val hashmap = HashMap<String, MutableList<String>>()

    for (str in strs) {
        val charArray = str.toCharArray()
        charArray.sort()
        val sortedStr = String(charArray)

        if (hashmap.containsKey(sortedStr)) {
            hashmap[sortedStr]?.add(str)
        } else {
            hashmap[sortedStr] = mutableListOf(str)
        }
    }

    return hashmap.values.map { it.sorted() }
}
