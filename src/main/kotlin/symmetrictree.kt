import java.util.LinkedList

// https://leetcode.com/problems/symmetric-tree/
//Given a binary tree t, determine whether it is symmetric around its center, i.e. each side mirrors the other.
//
//Example
//
//For
//
//t = {
//    "value": 1,
//    "left": {
//        "value": 2,
//        "left": {
//        "value": 3,
//        "left": null,
//        "right": null
//    },
//        "right": {
//        "value": 4,
//        "left": null,
//        "right": null
//    }
//    },
//    "right": {
//        "value": 2,
//        "left": {
//        "value": 4,
//        "left": null,
//        "right": null
//    },
//        "right": {
//        "value": 3,
//        "left": null,
//        "right": null
//    }
//    }
//}
//the output should be solution(t) = true.
//
//Here's what the tree in this example looks like:
//
//1
/// \
//2   2
/// \ / \
//3  4 4  3
//As you can see, it is symmetric.
//
//For
//
//t = {
//    "value": 1,
//    "left": {
//        "value": 2,
//        "left": null,
//        "right": {
//        "value": 3,
//        "left": null,
//        "right": null
//    }
//    },
//    "right": {
//        "value": 2,
//        "left": null,
//        "right": {
//        "value": 3,
//        "left": null,
//        "right": null
//    }
//    }
//}
//the output should be solution(t) = false.
//
//Here's what the tree in this example looks like:
//
//1
/// \
//2   2
//\   \
//3    3
//As you can see, it is not symmetric.
//
//Input/Output
//
//[execution time limit] 3 seconds (kt)
//
//[input] tree.integer t
//
//A binary tree of integers.
//
//Guaranteed constraints:
//0 ≤ tree size < 5 · 104,
//-1000 ≤ node value ≤ 1000.
//
//[output] boolean
//
//Return true if t is symmetric and false otherwise.


/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

val treeNode = TreeNode(1).apply {
    left = TreeNode(1)
    right = TreeNode(2)
    left?.left = TreeNode(3)
    left?.right = TreeNode(4)
    right?.left = TreeNode(4)
    right?.right = TreeNode(3)
}

fun main() {
    println(isSymmetricTreeIterative(treeNode))
    println(isSymmetricTreeRecursive(treeNode.left, treeNode.right))
}

fun isSymmetricTreeIterative(root: TreeNode?): Boolean {
    val stack = LinkedList<TreeNode>()
    stack.push(root?.left)
    stack.push(root?.right)
    while (stack.isNotEmpty()) {
        val leftNode = stack.pop()
        val rightNode = stack.pop()
        if (leftNode == null && rightNode == null) {
            continue
        }
        if (leftNode == null || rightNode == null || leftNode.value != rightNode.value) {
            return false
        }
        stack.push(leftNode.left)
        stack.push(rightNode.right)
        stack.push(leftNode.right)
        stack.push(rightNode.left)
    }
    return true
}

fun isSymmetricTreeRecursive(leftNode: TreeNode?, rightNode: TreeNode?): Boolean =
    when {
        leftNode == null && rightNode == null -> true
        leftNode == null || rightNode == null || leftNode.value != rightNode.value -> false
        else -> isSymmetricTreeRecursive(leftNode.left, rightNode.right) && isSymmetricTreeRecursive(leftNode.right, rightNode.left)
    }
