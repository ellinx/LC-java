package ellinx.solutions;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example, 
 * Given: 
 * s1 = "aabcc", 
 * s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true. 
 * When s3 = "aadbbbaccc", return false.
 *
 */
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;

		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
		dp[0][0] = true;
		for (int i = 1; i < s1.length() + 1; i++) {
			if (s1.substring(0, i).equals(s3.substring(0, i)))
				dp[i][0] = true;
		}

		for (int i = 1; i < s2.length() + 1; i++) {
			if (s2.substring(0, i).equals(s3.substring(0, i)))
				dp[0][i] = true;
		}

		for (int i = 1; i < s1.length() + 1; i++) {
			for (int j = 1; j < s2.length() + 1; j++) {
				char a = s3.charAt(i + j - 1);
				dp[i][j] = dp[i - 1][j] && (a == s1.charAt(i - 1));
				dp[i][j] = dp[i][j] || (dp[i][j - 1] && (a == s2.charAt(j - 1)));
			}
		}
		return dp[s1.length()][s2.length()];
	}
	
	//test
	public static void main(String[] args) {
		InterleavingString is = new InterleavingString();
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		boolean result = is.isInterleave(s1, s2, s3);
		System.out.println(result);
	}
}
