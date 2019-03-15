package solutions;

import java.util.Stack;

/**
Implement an iterator over a binary search tree (BST). 
Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Example:

       7
     /   \
    3     15
         /  \
       9     20

BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
 

Note:
1. next() and hasNext() should run in average O(1) time and uses O(h) memory, 
	where h is the height of the tree.
2. You may assume that next() call will always be valid, that is, 
	there will be at least a next smallest number in the BST when next() is called.
 */

public class BinarySearchTreeIterator {
    private Stack<TreeNode> stk;

    public BinarySearchTreeIterator(TreeNode root) {
        stk = new Stack<>();
        while (root!=null) {
            stk.push(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stk.pop();
        int ret = cur.val;
        cur = cur.right;
        while (cur!=null) {
            stk.push(cur);
            cur = cur.left;
        }
        return ret;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stk.isEmpty();
    }
}
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */