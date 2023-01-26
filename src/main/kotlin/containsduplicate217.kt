// https://leetcode.com/problems/contains-duplicate/

fun main() {
    println(containsDuplicate(intArrayOf(1,2,3,1)))
}

fun containsDuplicate(nums: IntArray): Boolean {
    val set = HashSet<Int>()
    nums.forEach { n ->
        if (set.contains(n)) {
            return true
        }
        set.add(n)
    }
    return false
}