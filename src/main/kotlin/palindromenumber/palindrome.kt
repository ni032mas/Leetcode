package palindromenumber

fun isPalindromeBruteForce(x: Int): Boolean {
    val xString = x.toString()
    val stringBuilder = StringBuilder()
    for (i in xString.length - 1 downTo 0) {
        stringBuilder.append(xString[i])
    }
    return xString == stringBuilder.toString()
}

fun isPalindrome(x: Int): Boolean {
    if (x < 0) return false
    var input = x
    var reversedX = 0
    var lastDigit: Int
    while (input != 0) {
        lastDigit = input % 10
        reversedX = reversedX * 10 + lastDigit
        input /= 10
    }
    return x == reversedX
}

