package solutions;

import java.util.Stack;

/**
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST 
such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9
Output: True
 

Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28
Output: False
 */

public class TwoSumIVInputIsABST {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> stk1 = new Stack<>();
        TreeNode cur = root;
        while (cur!=null) {
            stk1.push(cur);
            cur = cur.left;
        }
        Stack<TreeNode> stk2 = new Stack<>();
        cur = root;
        while (cur!=null) {
            stk2.push(cur);
            cur = cur.right;
        }
        // System.out.println(stk1.size()+","+stk2.size());
        while (!stk1.isEmpty() && !stk2.isEmpty()) {
            TreeNode left = stk1.pop();
            TreeNode right = stk2.pop();
            // System.out.println(left.val+","+right.val);
            if (left.val>=right.val) {
                break;
            }
            if (left.val+right.val==k) {
                return true;
            }
            if (left.val+right.val>k) {
                stk1.push(left);
                right = right.left;
                while (right!=null) {
                    stk2.push(right);
                    right = right.right;
                }
            } else {
                stk2.push(right);
                left = left.right;
                while (left!=null) {
                    stk1.push(left);
                    left = left.left;
                }
            }
        }
        return false;
    }
}
