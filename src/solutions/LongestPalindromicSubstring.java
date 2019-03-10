package solutions;

/**
Given a string s, find the longest palindromic substring in s. 
You may assume that the maximum length of s is 1000.

Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: "cbbd"
Output: "bb"
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String ret = "";
        int n = s.length();
        for (int i=0;i<n;i++) {
            //odd length
            int l=i-1, r=i+1;
            while (l>=0 && r<n && s.charAt(l)==s.charAt(r)) {
                l--;
                r++;
            }
            l++;
            r--;
            if (ret.length()<r-l+1) {
                ret = s.substring(l,r+1);
            }
            //even length
            l = i;
            r = i+1;
            while (l>=0 && r<n && s.charAt(l)==s.charAt(r)) {
                l--;
                r++;
            }
            l++;
            r--;
            if (ret.length()<r-l+1) {
                ret = s.substring(l,r+1);
            }
        }
        return ret;
    }
	
	//test
	public static void main(String[] args) {
		LongestPalindromicSubstring tmp = new LongestPalindromicSubstring();
		String result = tmp.longestPalindrome("cbbd");
		System.out.println(result);
	}
}
