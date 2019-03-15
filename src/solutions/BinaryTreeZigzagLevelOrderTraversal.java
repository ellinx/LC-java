package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
        if (root==null) {
            return ret;
        }
        boolean flag = true;
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        while (!cur.isEmpty()) {
            List<TreeNode> next = new ArrayList<>();
            List<Integer> vals = new ArrayList<>();
            for (TreeNode each:cur) {
                vals.add(each.val);
                if (each.left!=null) {
                    next.add(each.left);
                }
                if (each.right!=null) {
                    next.add(each.right);
                }
            }
            if (flag) {
                ret.add(vals);
                flag = false;
            } else {
                Collections.reverse(vals);
                ret.add(vals);
                flag = true;
            }
            cur = next;
        }
        return ret;
    }
}
