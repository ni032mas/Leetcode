// https://leetcode.com/problems/reverse-linked-list/
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
fun main() {
    val node = ListNode(3).apply {
        next = ListNode(5)
        next?.next = ListNode(8)
        next?.next?.next = ListNode(9)
        next?.next?.next?.next = ListNode(1)
    }
    println(reverseList(node))
    println(reverseListRecursive(node))
}

fun reverseList(head: ListNode?): ListNode? {
    var previousNode: ListNode? = null
    var currentNode = head
    while (currentNode != null) {
        val nextNode = currentNode.next
        currentNode.next = previousNode
        previousNode = currentNode
        currentNode = nextNode
    }
    return head
}

fun reverseListRecursive(head: ListNode?): ListNode? {
    if (head == null) {
        return null
    }
    if (head.next == null) {
        return head
    }
    val node = reverseListRecursive(head.next)
    head.next?.next = head
    head.next = null
    return node
}