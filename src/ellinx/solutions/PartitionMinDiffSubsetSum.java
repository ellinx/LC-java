package ellinx.solutions;

import java.util.Arrays;

/**
 * Given a non-empty array containing only positive integers, partition the array
 * into two subsets and find the minimum difference of the sums of these two subsets.
 * 
 * Note: Each of the array element will not exceed 100. The array size will not
 * exceed 200. 
 * 
 * Example 1:
 * Input: [1, 5, 11, 5]
 * Output: 0
 * 
 * Explanation: 
 * The array can be partitioned as [1, 5, 5] and [11]. And the difference of the 
 * two subsets is 0.
 * 
 * Example 2:
 * Input: [1, 2, 3, 5]
 * Output: 1
 * 
 * Explanation: 
 * The array can be partitioned as [1, 2, 3] and [5]. And the difference of the 
 * two subsets is 1.
 * 
 * @author Ellinx
 *
 */
public class PartitionMinDiffSubsetSum {
	public int minDiff(int[] nums) {
		int n = nums.length;
		int total = 0;
		int capacity = 0;
		for (int num:nums) {
			total += num;
		}
		capacity = total>>1;
		
		//dp[i][j] is max sum I can get from nums[0~i-1] and sum is less than j
		int[][] dp = new int[n+1][capacity+1];
		for (int i=1;i<=n;i++) {
			for (int j=1;j<=capacity;j++) {
				dp[i][j] = dp[i-1][j];
				if (j>=nums[i-1]) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-nums[i-1]]+nums[i-1]);
				}
			}
		}
		for (int i=0;i<n;i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		return (total-(dp[n][capacity]<<1));
	}
	
	//test
	public static void main(String[] args) {
		PartitionMinDiffSubsetSum pmdss = new PartitionMinDiffSubsetSum();
		int[] nums = {1, 5, 11, 5};
		int result = pmdss.minDiff(nums);
		System.out.println(result);
	}
}
