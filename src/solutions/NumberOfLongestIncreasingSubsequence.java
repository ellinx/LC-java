package solutions;

/**
 * 
 * Given an unsorted array of integers, find the number of longest increasing
 * subsequence.
 * 
 * Example 1:
 * 
 * Input: [1,3,5,4,7] 
 * Output: 2 
 * Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 * 
 * Example 2:
 * 
 * Input: [2,2,2,2,2] 
 * Output: 5 
 * Explanation: The length of longest continuous increasing subsequence is 1, 
 * and there are 5 subsequences' length is 1, so output 5.
 * 
 * Note: Length of the given array will be not exceed 2000 and the answer is
 * guaranteed to be fit in 32-bit signed int.
 * 
 * @author Ellinx
 *
 */
public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length==0) {
            return 0;
        }
        //dp[i][0] is the length of LIS ends at i
        //dp[i][1] is the number if LIS ends at i
        int[][] dp = new int[nums.length][2];
        int[] max = new int[]{1, 1};
        dp[0] = new int[]{1, 1};
        for (int i=1;i<nums.length;i++) {
            dp[i] = new int[]{1, 1};
            for (int j=0;j<i;j++) {
                if (nums[j]>=nums[i]) {
                    continue;
                }
                if (dp[j][0]+1>dp[i][0]) {
                    dp[i][0] = dp[j][0]+1;
                    dp[i][1] = dp[j][1];
                } else if (dp[j][0]+1==dp[i][0]) {
                    dp[i][1] += dp[j][1];
                }
            }
            if (dp[i][0]>max[0]) {
                max[0] = dp[i][0];
                max[1] = dp[i][1];
            } else if (dp[i][0]==max[0]) {
                max[1] += dp[i][1];
            }
        }
        // for (int[] each:dp) {
        //     System.out.println(Arrays.toString(each));
        // }
        return max[1];
    }
}
