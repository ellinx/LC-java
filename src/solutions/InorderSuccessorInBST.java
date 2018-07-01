package solutions;

import java.util.Stack;

/**
 * 
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * 
 * Note: If the given node has no in-order successor in the tree, return null.
 * 
 * Example 1:
 * 
 * Input: root = [2,1,3], p = 1
 * 
 *   2
 *  / \
 * 1   3
 * 
 * Output: 2
 * 
 * Example 2:
 * 
 * Input: root = [5,3,6,2,4,null,null,1], p = 6
 * 
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /   
 * 1
 * 
 * Output: null
 * 
 *
 */
public class InorderSuccessorInBST {
	/**
	 * Thoughts:
	 * 1. Inorder traverse the BST
	 * 
	 * Time: O(n) where n is total number of nodes in the tree
	 * Space: O(n)
	 */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode pre = null;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        while (cur!=null) {
            stk.push(cur);
            cur = cur.left;
        }
        while (!stk.isEmpty()) {
            cur = stk.pop();
            if (pre==p) {
                return cur;
            }
            pre = cur;
            cur = cur.right;
            while (cur!=null) {
                stk.push(cur);
                cur = cur.left;
            }
        }
        return null;
    }
}
