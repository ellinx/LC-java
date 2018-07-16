package solutions;

import java.util.HashMap;
import java.util.Map;

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
	/**
	 * Thoughts:
	 * 1. dynamic programming
	 * 
	 */
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
	
	/**
	 * Thoughts:
	 * 1. DFS
	 */
    private Map<String,Boolean> map = new HashMap<>();
    public boolean isInterleaveDFS(String s1, String s2, String s3) {
        //System.out.println(s1+","+s2+","+s3);
        if (s1.length()+s2.length()!=s3.length()) {
            return false;
        }
        if (s3.length()==0) {
            return true;
        }
        if (s1.length()==0) {
            return s2.equals(s3);
        }
        if (map.containsKey(s1+","+s2+","+s3)) {
            return map.get(s1+","+s2+","+s3);
        }
        for (int i=0;i<s3.length();i++) {
            if (s1.charAt(0)==s3.charAt(i)) {
                if (i==0) {
                    if (isInterleave(s1.substring(1),s2,s3.substring(1))) {
                        map.put(s1+","+s2+","+s3, true);
                        return true;
                    }
                } else {
                    if (s2.length()>=i && s2.substring(0,i).equals(s3.substring(0,i))) {
                        if (isInterleave(s1.substring(1),s2.substring(i),s3.substring(i+1))) {
                            map.put(s1+","+s2+","+s3, true);
                            return true;
                        }
                    }
                }
            }
        }
        map.put(s1+","+s2+","+s3, false);
        return false;
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
