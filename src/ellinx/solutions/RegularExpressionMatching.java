package ellinx.solutions;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. 
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: 
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples: 
 * isMatch("aa","a") → false 
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false 
 * isMatch("aa", "a*") → true 
 * isMatch("aa", ".*") → true 
 * isMatch("ab", ".*") → true 
 * isMatch("aab", "c*a*b") → true
 * 
 * @author Ellinx
 *
 */
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        if (n==0 && m==0)
            return true;

        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        
        for (int i=2;i<=n;i++) {
            if (p.charAt(i-1)=='*') {
                dp[0][i] = dp[0][i-2];
            }
        }
        
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                if (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1)=='*') {
                    if (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.') {
                        dp[i][j] = (dp[i][j-2]+dp[i-1][j-2]+dp[i-1][j]>0)?1:0; //a* stands for no a, one a and multiple a.
                    } else {
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }
        return dp[m][n]==1;
    }
	
	//test
	public static void main(String[] args) {
		RegularExpressionMatching rem = new RegularExpressionMatching();
		boolean result = rem.isMatch("aab", "c*a*b*");
		System.out.println(result);
	}
}
