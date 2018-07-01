package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * 
 * @author Ellinx
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	/**
	 * Thoughts:
	 * 1.BFS visited whole tree level by level and then reverse even level.
	 * 
	 * Time: O(n) where n is total number of nodes in the tree
	 * Space: O(n)
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        List<TreeNode> cur = new ArrayList<>();
        if (root!=null)
            cur.add(root);
        while (cur.size()!=0) {
            List<TreeNode> next = new ArrayList<>();
            List<Integer> curInt = new ArrayList<>();
            for (TreeNode node : cur) {
                curInt.add(node.val);
                if (node.left!=null)
                    next.add(node.left);
                if (node.right!=null)
                    next.add(node.right);
            }
            ret.add(curInt);
            cur = next;
        }
        for (int i=0;i<ret.size();i++) {
            if (i%2==1) {
                Collections.reverse(ret.get(i));
            }
        }
        return ret;
    }
}
