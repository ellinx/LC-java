package solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]

Follow up: Recursive solution is trivial, could you do it iteratively?
 */

public class BinaryTreePostorderTraversal {
	// recursive
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        dfs(root, ret);
        return ret;
    }
    private void dfs(TreeNode root, List<Integer> ret) {
        if (root==null) {
            return;
        }
        dfs(root.left, ret);
        dfs(root.right, ret);
        ret.add(root.val);
    }
    
    //iterative
    public List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        Deque<Integer> dq = new ArrayDeque<>();
        while (root!=null || !stk.isEmpty()) {
            if (root!=null) {
                stk.push(root);
                dq.offerFirst(root.val);
                root = root.right;
            } else {
                root = stk.pop();
                root = root.left;
            }
        }
        return new ArrayList<Integer>(dq);
    }
}
