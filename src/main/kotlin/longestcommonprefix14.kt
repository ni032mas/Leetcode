fun main() {
    println(longestCommonPrefix(arrayOf("flower","flower","flower","flower")))
    println(longestCommonPrefix(arrayOf("aaa","aa","aaa")))
    println(longestCommonPrefix(arrayOf("flower","flow","flight")))
    println(longestCommonPrefix(arrayOf("dog","racecar","car")))
}

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    if (strs.size == 1) return strs[0]
    val prefStart = strs[0]
    var pref = ""
    var res = ""
    for (i in prefStart.length downTo 1) {
        for (j in 1 until strs.size) {
            if (i <= strs[j].length &&
                prefStart.substring(0, i) == strs[j].substring(0, i)
            ) {
                pref = prefStart.substring(0, i)
            } else {
                pref = ""
                break
            }
        }
        if (pref.length > res.length) res = pref
    }
    return res
}