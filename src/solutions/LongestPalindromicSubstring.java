package ellinx.solutions;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer. 
 * 
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 * 
 * @author Ellinx
 *
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s.isEmpty()) return "";
		
		String res1 = "";
        //substring length is even
		for (int i=0;i<s.length()-1;i++) {
			int longestPossible = 2*Math.min(i+1, s.length()-i-1);
			if (longestPossible < res1.length()) {
				break;
			}
			
			if (s.charAt(i) == s.charAt(i+1)) {
				int offset = 1;
				while (i-offset>=0 && i+1+offset<s.length()) {
					if (s.charAt(i-offset) == s.charAt(i+1+offset)) {
						offset++;
					} else {
						break;
					}
				}
				offset--;
				String tmp = s.substring(i-offset, i+2+offset);
				res1 = (res1.length() < tmp.length())?tmp:res1;
			}
		}
		
		String res2 = "";
		//substring length is odd
		for (int i=0;i<s.length();i++) {
			int longestPossible = 2*Math.min(i, s.length()-i)+1;
			if (longestPossible < res2.length()) {
				break;
			}
			
			int offset = 1;
			while (i-offset>=0 && i+offset<s.length()) {
				if (s.charAt(i-offset) == s.charAt(i+offset)) {
					offset++;
				} else {
					break;
				}
			}
			offset--;
			String tmp = s.substring(i-offset, i+offset+1);
			res2 = (res2.length() < tmp.length())?tmp:res2;
		}
		
		return (res1.length()<res2.length())?res2:res1;
    }
	
	//test
	public static void main(String[] args) {
		LongestPalindromicSubstring tmp = new LongestPalindromicSubstring();
		String result = tmp.longestPalindrome("cbbd");
		System.out.println(result);
	}
}
