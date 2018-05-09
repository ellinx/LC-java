package ellinx.solutions;

import java.util.Arrays;

/**
 * Given a non-empty array containing only positive integers, find if the array
 * can be partitioned into two subsets such that the sum of elements in both
 * subsets is equal.
 * 
 * Note: Each of the array element will not exceed 100. The array size will not
 * exceed 200. 
 * 
 * Example 1:
 * Input: [1, 5, 11, 5]
 * Output: true
 * 
 * Explanation: The array can be partitioned as [1, 5, 5] and [11]. 
 * 
 * Example 2:
 * Input: [1, 2, 3, 5]
 * Output: false
 * 
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * 
 * @author Ellinx
 *
 */
public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
		int n = nums.length;
        int sum = 0;
        
        for (int i=0;i<n;i++) {
        	sum += nums[i];
        }
        
        if (sum%2==1) return false;
        sum = sum>>1;
        
        boolean[][] dp = new boolean[n+1][sum+1];
        
        for (int i=0;i<n+1;i++) {
        	dp[i][0] = true;
        }
        
        for (int i=1;i<=n;i++) {
        	for (int j=1;j<=sum;j++) {
        		dp[i][j] = dp[i-1][j];
        		if (nums[i-1]<=j) {
        			dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
        		}
        	}
        }
        for (int i=0;i<=n;i++) {
        	System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n][sum];
    }
	
	//test
	public static void main(String[] args) {
		PartitionEqualSubsetSum tmp = new PartitionEqualSubsetSum();
		int[] nums = {1, 5, 2};
		boolean result = tmp.canPartition(nums);
		System.out.println(result);
	}
}
