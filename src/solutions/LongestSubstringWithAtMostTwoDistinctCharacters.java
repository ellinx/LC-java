package solutions;

import java.util.HashMap;
import java.util.Map;

/**
Given a string s , find the length of the longest substring t  
that contains at most 2 distinct characters.

Example 1:
Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.

Example 2:
Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
 */

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character,Integer> counter = new HashMap<>();
        int l=0, r=0;
        int ret = 0;
        while (r<s.length()) {
            if (counter.containsKey(s.charAt(r))) {
                counter.put(s.charAt(r), counter.get(s.charAt(r))+1);
                r++;
                ret = Math.max(ret,r-l);
                continue;
            }
            counter.put(s.charAt(r),1);
            r++;
            while (counter.size()>2) {
                counter.put(s.charAt(l), counter.get(s.charAt(l))-1);
                if (counter.get(s.charAt(l))==0) {
                    counter.remove(s.charAt(l));
                }
                l++;
            }
            ret = Math.max(ret, r-l);
        }
        return ret;
    }
}
