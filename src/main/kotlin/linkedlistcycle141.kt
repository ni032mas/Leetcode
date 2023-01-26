class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        return toStringNode(this)
    }

    private fun toStringNode(root: ListNode?, str: String = ""): String =
        if (root?.next == null) {
            "$str${root?.`val`}"
        } else {
            toStringNode(root.next, "$str${root.`val`}")
        }
}

fun hasCycle(head: ListNode?): Boolean {
    if (head == null) return false
    var slow: ListNode? = head
    var fast: ListNode? = head
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
        if (slow == fast) return true
    }
    return false
}

fun main() {
    val listNode = ListNode(3).apply {
        next = ListNode(2)
        next?.next = ListNode(0)
        next?.next?.next = ListNode(-4)
        next?.next?.next?.next = ListNode(-7)
        next?.next?.next?.next?.next = ListNode(6)
        next?.next?.next?.next?.next?.next = ListNode(-10)
        next?.next?.next?.next?.next?.next?.next = this
    }
    println(hasCycle(listNode))
}