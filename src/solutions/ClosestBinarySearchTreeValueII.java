package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
Given a non-empty binary search tree and a target value, 
find k values in the BST that are closest to the target.

Note:
1. Given target value is a floating point.
2. You may assume k is always valid, that is: k ≤ total nodes.
3. You are guaranteed to have only one unique set of k values in the BST that are closest to the target.

Example:

Input: root = [4,2,5,1,3], target = 3.714286, and k = 2

    4
   / \
  2   5
 / \
1   3

Output: [4,3]

Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 */

public class ClosestBinarySearchTreeValueII {
    
    private Stack<TreeNode> stk1;
    private Stack<TreeNode> stk2;
    
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        TreeNode cur = root;
        //set up stk1
        stk1 = new Stack<>();
        while (cur!=null || !stk1.isEmpty()) {
            if (cur!=null) {
                stk1.push(cur);
                cur = cur.right;
            } else {
                if (stk1.peek().val<=target) {
                    break;
                }
                cur = stk1.pop();
                cur = cur.left;
            }
        }
        // set up stk2
        cur = root;
        stk2 = new Stack<>();
        while (cur!=null || !stk2.isEmpty()) {
            if (cur!=null) {
                stk2.push(cur);
                cur = cur.left;
            } else {
                if (stk2.peek().val>target) {
                    break;
                }
                cur = stk2.pop();
                cur = cur. right;
            }
        }
        // collect result
        List<Integer> ret = new ArrayList<>();
        while (peekNextLeft()!=null && peekNextRight()!=null) {
            int left = peekNextLeft().val;
            int right = peekNextRight().val;
            // System.out.println(left+","+right);
            if (target-left<=right-target) {
                ret.add(left);
                getNextLeft();
            } else {
                ret.add(right);
                getNextRight();
            }
            if (ret.size()==k) {
                return ret;
            }
        }
        while (peekNextLeft()!=null) {
            ret.add(getNextLeft().val);
            if (ret.size()==k) {
                break;
            }
        }
        while (peekNextRight()!=null) {
            ret.add(getNextRight().val);
            if (ret.size()==k) {
                break;
            }
        }
        return ret;
    }
    private TreeNode peekNextLeft() {
        if (stk1.isEmpty()) {
            return null;
        }
        return stk1.peek();
    }
    private TreeNode getNextLeft() {
        TreeNode ret = stk1.pop();
        TreeNode cur = ret.left;
        while (cur!=null) {
            stk1.push(cur);
            cur = cur.right;
        }
        return ret;
    }
    private TreeNode peekNextRight() {
         if (stk2.isEmpty()) {
            return null;
        }
        return stk2.peek();
    }
    private TreeNode getNextRight() {
        TreeNode ret = stk2.pop();
        TreeNode cur = ret.right;
        while (cur!=null) {
            stk2.push(cur);
            cur = cur.left;
        }
        return ret;
    }
}
