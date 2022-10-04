package romantointeger

private val romans: HashMap<Char, Int> = hashMapOf(
    'I' to 1,
    'V' to 5,
    'X' to 10,
    'L' to 50,
    'C' to 100,
    'D' to 500,
    'M' to 1000,
)

fun romanToIntBruteForce(s: String): Int {
    var output = 0
    var prevChar: Char? = null
    s.forEach { char ->
        val currentInt = romans[char] ?: 0
        val prevInt = romans[prevChar] ?: 0
        if (prevInt != 0 && prevInt < currentInt) {
            output = output + currentInt - prevInt - prevInt
        } else {
            output += currentInt
        }
        prevChar = char
    }
    return output
}