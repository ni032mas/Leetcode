//fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
//    val nums1Length = nums1.size
//    val nums2Length = nums2.size
//    val value = 3
//    var isValueFound = false
//    if (nums1[nums1Length / 2] != value && nums1[nums1Length / 2] > value)  {
//
//    }
//    while () {
//
//    }
//}

fun binarySearch(
    array: IntArray,
    searchedValue: Int,
    firstPosition: Int = 0,
    lastPosition: Int = array.size,
    searchedPosition: Int = array.size / 2
): Int {
    if (array[searchedPosition] == searchedValue) return searchedPosition
    return if (array[searchedPosition] < searchedValue) {
        binarySearch(
            array = array,
            searchedValue = searchedValue,
            firstPosition = searchedPosition,
            lastPosition = lastPosition,
            searchedPosition = searchedPosition + (lastPosition - searchedPosition) / 2,
        )
    } else {
        binarySearch(
            array = array,
            searchedValue = searchedValue,
            firstPosition = firstPosition,
            lastPosition = searchedPosition,
            searchedPosition = searchedPosition / 2,
        )
    }
}

fun findMedianSortedArraysBruteForce(nums1: IntArray, nums2: IntArray): Double {
    val nums1Length = nums1.size
    val nums2Length = nums2.size
    val mergedArray = IntArray(nums1Length + nums2Length)
    var nums1Position = 0
    var nums2Position = 0
    var mergedPosition = 0
    while (nums1Position < nums1Length && nums2Position < nums2Length) {
        if (nums1[nums1Position] < nums2[nums2Position]) {
            mergedArray[mergedPosition++] = nums1[nums1Position++]
        } else {
            mergedArray[mergedPosition++] = nums2[nums2Position++]
        }
    }

    while (nums1Position < nums1Length) {
        mergedArray[mergedPosition++] = nums1[nums1Position++]
    }

    while (nums2Position < nums2Length) {
        mergedArray[mergedPosition++] = nums2[nums2Position++]
    }

    val mergedArraySize = mergedArray.size

    return when {
        mergedArraySize == 1 -> mergedArraySize.toDouble()
        mergedArraySize % 2 == 0 -> (mergedArray[(mergedArraySize / 2) - 1].toDouble() + mergedArray[(mergedArraySize / 2)].toDouble()) / 2
        mergedArraySize % 2 != 0 -> mergedArray[(mergedArraySize / 2)].toDouble()
        else -> mergedArraySize.toDouble()
    }
}