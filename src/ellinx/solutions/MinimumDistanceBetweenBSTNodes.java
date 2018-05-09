package ellinx.solutions;

import java.util.Stack;

/**
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference 
 * between the values of any two different nodes in the tree.
 * 
 * Example :
 *
 * Input: root = [4,2,6,1,3,null,null]
 * Output: 1
 * Explanation:
 * Note that root is a TreeNode object, not an array.
 *
 * The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
 *
 *          4
 *        /   \
 *      2      6
 *     / \    
 *    1   3  
 *
 * while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
 *
 * Note:
 * 1. The size of the BST will be between 2 and 100.
 * 2. The BST is always valid, each node's value is an integer, and each node's value is different.
 *
 */
public class MinimumDistanceBetweenBSTNodes {
	public int minDiffInBST(TreeNode root) {
        int res = Integer.MAX_VALUE;
        TreeNode pre = null;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        
        while (cur!=null) {
            stack.push(cur);
            cur = cur.left;
        }
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (pre!=null) {
                res = Math.min(res, cur.val-pre.val);
                //System.out.println("pre="+pre.val+",cur="+cur.val);
            }
            pre = cur;
            
            if (cur.right!=null) {
                cur = cur.right;
                while (cur!=null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }

        }
        return res;
    }
}
