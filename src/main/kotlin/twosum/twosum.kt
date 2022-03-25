package twosum

fun twoSum(nums: IntArray, target: Int): IntArray {
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