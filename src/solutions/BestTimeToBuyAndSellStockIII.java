package solutions;

import java.util.Arrays;

/**
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time 
(i.e., you must sell the stock before you buy again).

Example 1:
Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
             
Example 2:
Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
             
Example 3:
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        //        buy/sell
        //   0  <==========>  1
        int[][] dp = new int[2][3];
        dp[1][1] = -prices[0];
        dp[1][0] = -prices[0];
        for (int i=1;i<prices.length;i++) {
            int[][] ndp = new int[2][3];
            for (int j=0;j<2;j++) {
                ndp[j] = Arrays.copyOf(dp[j], dp[j].length);
            }
            dp[1][1] = Math.max(ndp[1][1], ndp[0][2] - prices[i]);
            dp[1][0] = Math.max(ndp[1][0], ndp[0][1] - prices[i]);
            dp[0][1] = Math.max(ndp[0][1], ndp[1][1] + prices[i]);
            dp[0][0] = Math.max(ndp[0][0], ndp[1][0] + prices[i]);
        }
        return Math.max(Math.max(dp[0][0], dp[0][1]), dp[0][2]);
    }
    
	//test
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockIII tmp = new BestTimeToBuyAndSellStockIII();
		int[] prices = {3,3,5,0,0,3,1,4};
		int result = tmp.maxProfit(prices);
		System.out.println(result);
	}
}
