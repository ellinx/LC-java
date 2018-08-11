package solutions;

/**
 * 
 * Given a string, your task is to count how many palindromic substrings in this
 * string.
 * 
 * The substrings with different start indexes or end indexes are counted as
 * different substrings even they consist of same characters.
 * 
 * Example 1:
 * 
 * Input: "abc" 
 * Output: 3 
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * Example 2:
 * 
 * Input: "aaa" 
 * Output: 6 
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * Note:
 * 
 * The input string length won't exceed 1000.
 * 
 * @author Ellinx
 *
 */
public class PalindromicSubstrings {
	/**
	 * 
	 * Time: O(n^2) where n is length of s
	 * Space: O(1)
	 */
    public int countSubstrings(String s) {
        int ret = 0;
        for (int i=0;i<s.length();i++) {
            int offset = 0;
            while (i-offset>=0 && i+offset<s.length() && s.charAt(i-offset)==s.charAt(i+offset)) {
                ret++;
                offset++;
            }
            offset = 0;
            while (i-offset>=0 && i+1+offset<s.length() && s.charAt(i-offset)==s.charAt(i+1+offset)) {
                ret++;
                offset++;
            }
        }
        return ret;
    }
}
