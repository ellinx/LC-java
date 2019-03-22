package solutions;

import java.util.HashMap;
import java.util.Map;

/**
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true

Example 2:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
 */
public class InterleavingString {

	 // Thoughts:
	 // 1. dynamic programming
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
	

	// Thoughts:
	// 1. DFS
    public boolean isInterleave2(String s1, String s2, String s3) {
        return isInterleave(s1, 0, s2, 0, s3, 0, new HashMap<String,Boolean>());
    }
    private boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3, Map<String, Boolean> mm) {
        String key = i1+","+i2+","+i3;
        if (mm.containsKey(key)) {
            return mm.get(key);
        }
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1-i1+l2-i2!=l3-i3) {
            mm.put(key, false);
            return false;
        }
        if (i1==l1 && i2==l2 && i3==l3) {
            mm.put(key, true);
            return true;
        }
        if (i1<l1 && s1.charAt(i1)==s3.charAt(i3)) {
            if (isInterleave(s1,i1+1,s2,i2,s3,i3+1,mm)) {
                mm.put(key, true);
                return true;
            }
        }
        if (i2<l2 && s2.charAt(i2)==s3.charAt(i3)) {
            if (isInterleave(s1,i1,s2,i2+1,s3,i3+1,mm)) {
                mm.put(key, true);
                return true;
            }
        }
        mm.put(key, false);
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
