// https://leetcode.com/problems/merge-two-sorted-lists/
fun main() {
    println(
        mergeTwoLists(
            list1 = constructLinkedList(1..10),
            list2 = constructLinkedList(1..10),
        )
    )
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val result: ListNode? = ListNode(0)
    var current = result

    var node1 = list1
    var node2 = list2
    while (node1 != null || node2 != null) {
        if (node1 == null) {
            current?.next = node2
            break
        }
        if (node2 == null) {
            current?.next = node1
            break
        }

        if (node1.`val` < node2.`val`) {
            current?.next = node1
            node1 = node1.next
        } else {
            current?.next = node2
            node2 = node2.next
        }
        current = current?.next
    }
    return result?.next
}
