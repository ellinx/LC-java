package solutions;

import java.util.Stack;

/**
 * 
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * 
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Example 1:
 * 
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * 
 * Example 2:
 * 
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * 
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
 * How would you optimize the kthSmallest routine?
 * 
 * @author Ellinx
 *
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();
        int index = 0;
        int pre = 0;
        TreeNode cur = root;
        while (cur!=null) {
            stk.push(cur);
            cur = cur.left;
        }
        while (!stk.isEmpty()) {
            cur = stk.pop();
            pre = cur.val;
            index++;
            //System.out.println("index="+index+",pre="+pre);
            if (index==k) {
                break;
            }
            cur = cur.right;
            while (cur!=null) {
                stk.push(cur);
                cur = cur.left;
            }
        }
        return pre;
    }
}
