package solutions;

/**
 * 
 * Given an array nums of n integers where n > 1, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Example:
 * 
 * Input: [1,2,3,4] Output: [24,12,8,6]
 * 
 * Note: Please solve it without division and in O(n).
 * 
 * Follow up: Could you solve it with constant space complexity? (The output
 * array does not count as extra space for the purpose of space complexity
 * analysis.)
 * 
 * @author Ellinx
 *
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            if (i==0) {
                left[0] = 1;
                right[right.length-1] = 1;
                continue;
            }
            left[i] = left[i-1]*nums[i-1];
            right[right.length-1-i] = right[right.length-i]*nums[right.length-i];
        }
        int[] ret = new int[nums.length];
        for (int i=0;i<ret.length;i++) {
            ret[i] = left[i]*right[i];
        }
        return ret;
    }
}
