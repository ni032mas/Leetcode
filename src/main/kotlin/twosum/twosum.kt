package twosum

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun twoSumBruteForce(nums: IntArray, target: Int): IntArray {
    val result = intArrayOf()

    for (i in 0..nums.size) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }

    return result
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val mapInt = HashMap<Int, Int>()
    for (i in nums.indices) {
        mapInt[nums[i]] = i
    }

    for (i in 0..nums.size) {
        mapInt[target - nums[i]]?.let { secondInt ->
            if (i != secondInt) return intArrayOf(i, secondInt)
        }
    }

    throw IllegalArgumentException("No solution")
}


fun main() {
//    println(twoSumBrute(intArrayOf(0, 5, 7, 2, 5), 10).contentToString())
    println(twoSumBruteWithHashSet(intArrayOf(0, 5, 7, 2, 5), 10).contentToString())
}

// [0, 1, 2, 3, 4] indices
// [0, 5, 7, 2, 5] target 10
// [1, 4]
// O(n2)
fun twoSumBrute(nums: IntArray, target: Int): IntArray {
    for (i in 0 until nums.size) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }
    return intArrayOf()
}

// [0, 1, 2, 3, 4] indices
// [0, 5, 7, 2, 5] target 10
// [1, 4]
//O(n)
fun twoSumBruteWithHashSet(nums: IntArray, target: Int): IntArray {
    val hashMap = HashMap<Int, Int>()
    for (i in 0 until nums.size) {
        hashMap[nums[i]] = i
    }
    for (i in 0 until nums.size) {
        val k = hashMap[target - nums[i]]
        if (k != null && k != i) {
            intArrayOf(i, k)
        }
    }
    return intArrayOf()
}