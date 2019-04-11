package solutions;

/**
Given an integer array nums, find the contiguous subarray (containing at least one number) 
which has the largest sum and return its sum.

Example:
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Follow up:
If you have figured out the O(n) solution, 
try coding another solution using the divide and conquer approach, 
which is more subtle.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int ret = nums[0];
        int cur = nums[0];
        for (int i=1;i<nums.length;i++) {
            if (cur<0) {
                cur = nums[i];
            } else {
                cur += nums[i];
            }
            ret = Math.max(ret, cur);
        }
        return ret;
    }
	
	//test
	public static void main(String[] args) {
		MaximumSubarray tmp = new MaximumSubarray();
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int result = tmp.maxSubArray(nums);
		System.out.println(result);
	}
}
