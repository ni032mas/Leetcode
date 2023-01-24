/*
- Дан список неотрицательных целых чисел, повторяющихся элементов в списке нет.
- Нужно преобразовать это множество в строку,
- сворачивая соседние по числовому ряду числа в диапазоны.
*/

fun main() {
    println(compress(listOf(1, 4, 5, 2, 3, 9, 8, 11, 0))) // "0-5,8-9,11"
//    println(compress(listOf(1, 4, 3, 2))) // "1-4"
//    println(compress(listOf(1, 4))) // "1,4"
//    println(compress(listOf(1, 2))) // "1-2"
//    println(compress(listOf(2))) // "2"
}

fun compress(list: List<Int>): String {
    if (list.size == 1) return list[0].toString()
    var res = ""
    val len = list.size - 1
    var lastPosition = 0
    val mutableList = list.sorted()
    var firstRangePosition = mutableList[0]
    if (mutableList.size == 1) return mutableList[0].toString()
    for (i in 1..len) {
        when {
            mutableList[i] - 1 == mutableList[i - 1] -> {
                lastPosition = mutableList[i]
            }
            firstRangePosition - 1 > lastPosition -> {
                res = "${if (res.isBlank()) res else "$res,"}$firstRangePosition"
            }

            mutableList[i] - 1 > mutableList[i - 1] -> {
                res = "${if (res.isBlank()) res else "$res,"}$firstRangePosition-$lastPosition"
                if (i != len) firstRangePosition = mutableList[i]
            }
        }
    }
    return res
}