package ellinx.solutions;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * 
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * 
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * 
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * @author Ellinx
 *
 */
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        Arrays.sort(coins);
        
        for (int i=coins.length-1;i>=0;i--) {
        	for (int j=coins[i];j<dp.length;j++) {
        		if (dp[j-coins[i]]!=-1 && (dp[j]==-1 || dp[j]>dp[j-coins[i]]+1)) {
        			dp[j] = dp[j-coins[i]]+1;
        		}
        	}
        	System.out.println(Arrays.toString(dp));
        }
        
        return dp[amount];
    }
	
	public static void main(String[] args) {
		CoinChange tmp = new CoinChange();
		int[] coins = {1,2,5};
		int result = tmp.coinChange(coins, 11);
		System.out.println(result);
	}
}
