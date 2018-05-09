package ellinx.solutions;

/**
 * Given a string that consists of only uppercase English letters, you can
 * replace any letter in the string with another letter at most k times. Find
 * the length of a longest substring containing all repeating letters you can
 * get after performing the above operations.
 * 
 * Note: Both the string's length and k will not exceed 104.
 * 
 * Example 1:
 * Input: s = "ABAB", k = 2
 * 
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa. 
 * 
 * Example 2:
 * Input: s = "AABABBA", k = 1
 * 
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * 
 * @author Ellinx
 *
 */
public class LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
        int[] letters = new int[26];
        int start=0,end=0;
        int maxSameCharCount = 0;
        int res = 0;
        
        for (;end<s.length();end++) {
        	letters[s.charAt(end)-'A']++;
        	maxSameCharCount = Math.max(maxSameCharCount, letters[s.charAt(end)-'A']);
        	
        	while (end-start+1-maxSameCharCount > k) {
        		letters[s.charAt(start)-'A']--;
        		start++;
        		maxSameCharCount = 0;
        		for (int i=0;i<26;i++) {
        			maxSameCharCount = Math.max(maxSameCharCount, letters[i]);
        		}
        	}
        	res = Math.max(res, end-start+1);
        }
        return res;
    }
	
	//test
	public static void main(String[] args) {
		LongestRepeatingCharacterReplacement tmp = new LongestRepeatingCharacterReplacement();
		int result = tmp.characterReplacement("A", 1);
		System.out.println(result);
	}
}
