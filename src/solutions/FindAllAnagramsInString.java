package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<Character,Integer> counter = new HashMap<>();
        for (char c:p.toCharArray()) {
            counter.put(c, counter.getOrDefault(c,0)+1);
        }
        int total = p.length();
        List<Integer> ret = new ArrayList<>();
        int l=0, r=0;
        while (r<s.length()) {
            if (!counter.containsKey(s.charAt(r))) {
                r++;
                continue;
            }
            if (counter.get(s.charAt(r))>0) {
                total--;
            }
            counter.put(s.charAt(r), counter.get(s.charAt(r))-1);
            r++;
            while (total==0) {
                if (r-l==p.length()) {
                    ret.add(l);
                }
                if (!counter.containsKey(s.charAt(l))) {
                    l++;
                    continue;
                }
                if (counter.get(s.charAt(l))>=0) {
                    total++;
                }
                counter.put(s.charAt(l), counter.get(s.charAt(l))+1);
                l++;
            }
        }
        return ret;
    }
	
	//test
	public static void main(String[] args) {
		FindAllAnagramsInString tmp = new FindAllAnagramsInString();
		List<Integer> result = tmp.findAnagrams("abab", "ab");
		System.out.println(result.toString());
	}
	
}
