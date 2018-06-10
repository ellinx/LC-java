package solutions;

import java.util.Stack;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling 
 * (a left node that shares the same parent node) or empty, flip it upside down and 
 * turn it into a tree where the original right nodes turned into left leaf nodes. 
 * Return the new root.
 * 
 * Example:
 * 
 * Input: [1,2,3,4,5]
 * 
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * 
 * Output: return the root of the binary tree [4,5,2,#,#,3,1]
 * 
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1  
 * 
 * 
 * @author Ellinx
 *
 */
public class BinaryTreeUpsideDown {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root==null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null) {
            stack.push(cur);
            cur = cur.left;
        }
        TreeNode newRoot = stack.pop();
        cur = newRoot;
        while (!stack.isEmpty()) {
            TreeNode next = stack.pop();
            cur.left = next.right;
            cur.right = next;
            cur = next;
        }
        cur.left = null;
        cur.right = null;
        return newRoot;
    }
}
