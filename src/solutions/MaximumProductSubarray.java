package solutions;

/**
Given an integer array nums, 
find the contiguous subarray within an array (containing at least one number) 
which has the largest product.

Example 1:
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int ret = nums[0];
        int min = nums[0], max = nums[0];
        for (int i=1;i<nums.length;i++) {
            int mn = Math.min(max*nums[i], min*nums[i]);
            mn = Math.min(mn, nums[i]);
            int mx = Math.max(max*nums[i], min*nums[i]);
            mx = Math.max(mx, nums[i]);
            min = mn;
            max = mx;
            ret = Math.max(ret, max);
        }
        return ret;
    }
}
