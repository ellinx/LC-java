package solutions;

import java.util.HashMap;
import java.util.Map;

/**
Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:
Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.

Example 2:
Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
 */

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character,Integer> counter = new HashMap<>();
        int ret = 0;
        int l=0, r=0;
        while (r<s.length()) {
            char c = s.charAt(r);
            counter.put(c, counter.getOrDefault(c, 0)+1);
            r++;
            while (counter.size()>k) {
                c = s.charAt(l);
                if (counter.get(c)==1) {
                    counter.remove(c);
                } else {
                    counter.put(c, counter.get(c)-1);
                }
                l++;
            }
            ret = Math.max(ret, r-l);
        }
        return ret;
    }
}
