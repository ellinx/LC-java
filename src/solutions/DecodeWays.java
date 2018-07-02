package solutions;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 
 * 'B' -> 2 
 * ... 
 * 'Z' -> 26
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * Input: "12" 
 * Output: 2 
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * Example 2:
 * 
 * Input: "226" 
 * Output: 3 
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * 
 * 
 * @author Ellinx
 *
 */
public class DecodeWays {
	/**
	 * Thoughts:
	 * 1. dp[i] stands for has many ways to decode s[0:i-1]
	 * 
	 * Time: O(n) where n is length of s
	 * Space: O(n)
	 */
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for (int i=1;i<dp.length;i++) {
            if (s.charAt(i-1)!='0') {
                dp[i] += dp[i-1];
            }
            if (i-2>=0) {
                int temp = Integer.parseInt(s.substring(i-2,i));
                if (temp>=10 && temp<=26) {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[dp.length-1];
    }
}
