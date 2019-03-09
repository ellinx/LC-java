package solutions;

import java.util.ArrayList;
import java.util.List;

/**
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if (root==null) {
            return ret;
        }
        dfs(root, "", ret);
        return ret;
    }
    private void dfs(TreeNode root, String cur, List<String> ret) {
        if (cur.length()>0) {
            cur += "->";
        }
        cur += root.val;
        if (root.left==null && root.right==null) {
            ret.add(cur);
            return;
        }
        if (root.left!=null) {
            dfs(root.left, cur, ret);
        }
        if (root.right!=null) {
            dfs(root.right, cur, ret);
        }
    }
}
