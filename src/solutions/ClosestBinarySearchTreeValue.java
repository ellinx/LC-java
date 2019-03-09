package solutions;

/**
Given a non-empty binary search tree and a target value, 
find the value in the BST that is closest to the target.

Note:
1. Given target value is a floating point.
2. You are guaranteed to have only one unique value in the BST that is closest to the target.

Example:

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4
 */

public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        TreeNode ret = null;
        TreeNode cur = root;
        while (cur!=null) {
            if (ret==null || Math.abs(ret.val-target)>Math.abs(cur.val-target)) {
                ret = cur;
            }
            if (cur.val>target) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return ret.val;
    }
}
