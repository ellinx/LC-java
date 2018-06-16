package solutions;

/**
 * 
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 * 
 * You may assume each number in the sequence is unique.
 * 
 * Consider the following binary search tree: 
 * 
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 
 * Example 1:
 * 
 * Input: [5,2,6,1,3]
 * Output: false
 * 
 * Example 2:
 * 
 * Input: [5,2,1,3,6]
 * Output: true
 * 
 * Follow up:
 * Could you do it using only constant space complexity?
 * 
 * @author Ellinx
 *
 */
public class VerifyPreorderSequenceInBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length-1);
    }
    
    private boolean helper(int[] preorder, int start, int end) {
        if (start>=end) {
            return true;
        }
        int leftend = start+1;
        while (leftend<=end && preorder[leftend]<preorder[start]) {
            leftend++;
        }
        int index = leftend;
        while (index<=end) {
            if (preorder[index]<=preorder[start]) {
                return false;
            }
            index++;
        }
        if (helper(preorder, start+1, leftend-1) && helper(preorder, leftend, end)) {
            return true;
        }
        return false;
    }
}
