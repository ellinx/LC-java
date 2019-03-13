package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        while (root!=null || !stk.isEmpty()) {
            if (root!=null) {
                stk.push(root);
                root = root.left;
            } else {
                root = stk.pop();
                ret.add(root.val);
                root = root.right;
            }
        }
        return ret;
    }
    
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        dfs(root, ret);
        return ret;
    }
    private void dfs(TreeNode root, List<Integer> ret) {
        if (root==null) {
            return;
        }
        dfs(root.left, ret);
        ret.add(root.val);
        dfs(root.right, ret);
    }
}
