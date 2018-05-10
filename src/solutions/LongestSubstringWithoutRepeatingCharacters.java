package ellinx.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * @author Ellinx
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        if (s.length()==0)
            return 0;
        
        int res = 1;
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        
        while (end < s.length()) {
            while (end < s.length() && !set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
            }
            res = Math.max(res, end-start);
            //System.out.println("start="+start+",end="+end);
            if (end==s.length())
                return res;
            
            while (s.charAt(start)!=s.charAt(end)) {
                set.remove(s.charAt(start));
                start++;
            }
            start++;
            end++;
        }
        return res;
    }
	
	//test
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
		int result = lswrc.lengthOfLongestSubstring("abcabcbb");
		System.out.println(result);
	}
}
