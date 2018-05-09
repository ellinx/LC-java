package ellinx.solutions;

public class HouseRobber {
	/**
	 * You are a professional robber planning to rob houses along a street. 
	 * Each house has a certain amount of money stashed, the only constraint 
	 * stopping you from robbing each of them is that adjacent houses have 
	 * security system connected and it will automatically contact the police 
	 * if two adjacent houses were broken into on the same night.
	 * 
	 * Given a list of non-negative integers representing the amount of money 
	 * of each house, determine the maximum amount of money you can rob tonight 
	 * without alerting the police.
	 */
	public int rob(int[] nums) {
        int n = nums.length;
        if (n==0) 
            return 0;
        
        int[][] dp = new int[n][2];
        dp[0][1] = nums[0];
        for (int i=1;i<n;i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0]+nums[i];
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
	
	
	
	//test
	public static void main(String[] args) {
		HouseRobber hr = new HouseRobber();
		int[] nums = {};
		int result = hr.rob(nums);
		System.out.println(result);
	}
}
