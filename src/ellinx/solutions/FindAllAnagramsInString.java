package ellinx.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * Input: s: "cbaebabacd" p: "abc"
 * 
 * Output: [0, 6]
 * Explanation: The substring with start index = 0 is "cba", which is an anagram
 * of "abc". The substring with start index = 6 is "bac", which is an anagram of
 * "abc". 
 * 
 * Example 2:
 * Input: s: "abab" p: "ab"
 * 
 * Output: [0, 1, 2]
 * Explanation: The substring with start index = 0 is "ab", which is an anagram
 * of "ab". The substring with start index = 1 is "ba", which is an anagram of
 * "ab". The substring with start index = 2 is "ab", which is an anagram of
 * "ab".
 * 
 * @author Ellinx
 *
 */
public class FindAllAnagramsInString {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
        if (s==null || s.length()<p.length()) return res;
        
        int[] letters = new int[26];
        int count = 0;
        for (int i=0;i<p.length();i++) {
        	char a = p.charAt(i);
        	if (letters[a-'a']==0) {
        		count++;
        	}
        	letters[a-'a']++;
        }
        
        int start = 0;
        int end = 0;
        while (end<p.length()) {
        	char a = s.charAt(end);
        	if (letters[a-'a']==1) {
        		count--;
        	}
        	letters[a-'a']--;
        	end++;
        }
        end--;
        while (end<s.length()) {
        	if (count==0) {
        		res.add(start);
        	}
        	
        	char a = s.charAt(start);
        	if (letters[a-'a']==0) {
        		count++;
        	}
        	letters[a-'a']++;
        	start++;
        	end++;
        	if (end==s.length()) break;
        	a = s.charAt(end);
        	if (letters[a-'a']==1) {
        		count--;
        	}
        	letters[a-'a']--;
        }
        return res;
    }
	
	//test
	public static void main(String[] args) {
		FindAllAnagramsInString tmp = new FindAllAnagramsInString();
		List<Integer> result = tmp.findAnagrams("abab", "ab");
		System.out.println(result.toString());
	}
	
}
