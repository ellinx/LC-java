package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
Given a binary tree, return the level order traversal of its nodes' values. 
(ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */
public class BinaryTreeLevelOrderTraversal {
	/**
	 * Thoughs:
	 * 1. BFS
	 * 
	 * Time: O(n) where n is total number of nodes in the tree
	 * Space: O(n)
	 */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root==null) {
            return ret;
        }
        List<TreeNode> cur = Arrays.asList(root);
        while (cur.size()>0) {
            List<TreeNode> next = new ArrayList<>();
            List<Integer> vals = new ArrayList<>();
            for (TreeNode node:cur) {
                vals.add(node.val);
                if (node.left!=null) {
                    next.add(node.left);
                }
                if (node.right!=null) {
                    next.add(node.right);
                }
            }
            ret.add(vals);
            cur = next;
        }
        return ret;
    }
}
