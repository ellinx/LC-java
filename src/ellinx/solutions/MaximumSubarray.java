package ellinx.solutions;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray
 * [4,-1,2,1] has the largest sum = 6.
 * 
 * click to show more practice.
 * 
 * More practice: If you have figured out the O(n) solution, try coding another
 * solution using the divide and conquer approach, which is more subtle.
 * 
 * @author Ellinx
 *
 */
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if (nums.length==1) {
			return nums[0];
		}
		
		//dp[i] stores maximum sum of subarray ending at i
        int[] dp = new int[nums.length]; 
        dp[0] = nums[0];
        int res = dp[0];
        for (int i=1;i<nums.length;i++) {
        	if (dp[i-1]<0) {
        		dp[i] = nums[i];
        	} else {
        		dp[i] = dp[i-1] + nums[i];
        	}
        	res = Math.max(res, dp[i]);
        }
        return res;
    }
	
	//test
	public static void main(String[] args) {
		MaximumSubarray tmp = new MaximumSubarray();
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int result = tmp.maxSubArray(nums);
		System.out.println(result);
	}
}
