import java.util.LinkedList

// https://leetcode.com/problems/valid-parentheses/submissions/885251714/
// https://leetcode.com/problems/valid-parentheses/description/

fun main() {
    println(isValid("{{}}[()]"))
    println(isValid("(("))
    println(isValid("("))
}

fun isValid(s: String):Boolean {
    if (s.length < 2) return false
    val stack = LinkedList<Char>()
    for (char in s) {
        if (char == '{' || char == '(' || char == '[') {
            stack.push(char)
        } else {
            if (stack.isEmpty()) return false
            val charFromStack = stack.pop()
            if (
                (charFromStack != '{' && char == '}') ||
                (charFromStack!= '(' && char == ')') ||
                (charFromStack != '[' && char == ']')
                ) {
                return false
            }
        }
    }
    if (stack.isNotEmpty()) return false
    return true
}