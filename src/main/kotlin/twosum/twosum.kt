package twosum

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