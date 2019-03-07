package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
	// dp
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num:nums) {
            total += num;
        }
        if (total%2==1) {
            return false;
        }
        int m = nums.length;
        int n = total/2;
        //dp[i][j] is whether can get subset sum equal j from first i elements
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                dp[i][j] = dp[i-1][j];
                if (!dp[i][j] && j-nums[i-1]>=0) {
                    dp[i][j] = dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[m][n];
    }
    
    // dfs + memorization
    public boolean canPartition2(int[] nums) {
        int N = nums.length;
        int total = 0;
        for (int num:nums) {
            total += num;
        }
        if (total%2==1) {
            return false;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return dfs(nums, 0, 0, total/2, new HashMap<String,Boolean>());
    }
    private boolean dfs(int[] nums, int start, int cur, int target, Map<String,Boolean> mm) {
        if (cur==target) {
            return true;
        }
        String key = start+","+cur;
        if (mm.containsKey(key)) {
            return mm.get(key);
        }
        for (int i=start;i<nums.length;i++) {
            if (cur+nums[i]<=target && dfs(nums, i+1, cur+nums[i], target, mm)) {
                mm.put(key, true);
                return true;
            }
        }
        mm.put(key, false);
        return false;
    }
	
	//test
	public static void main(String[] args) {
		PartitionEqualSubsetSum tmp = new PartitionEqualSubsetSum();
		int[] nums = {1, 5, 2};
		boolean result = tmp.canPartition(nums);
		System.out.println(result);
	}
}
