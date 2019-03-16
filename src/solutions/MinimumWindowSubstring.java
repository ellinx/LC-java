package solutions;

import java.util.HashMap;
import java.util.Map;

/**

Given a string S and a string T, find the minimum window in S 
which will contain all the characters in T in complexity O(n).

Example:
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

Note:
1. If there is no such window in S that covers all characters in T, 
	return the empty string "".
2. If there is such window, you are guaranteed 
	that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char c:t.toCharArray()) {
            counter.put(c, counter.getOrDefault(c,0)+1);
        }
        int total = t.length();
        String ret = "";
        int l=0, r=0;
        while (r<s.length()) {
            char c = s.charAt(r);
            if (!counter.containsKey(c)) {
                r++;
                continue;
            }
            if (counter.get(c)>0) {
                total--;
            }
            counter.put(c, counter.get(c)-1);
            r++;
            while (total==0) {
                if (ret.length()==0 || ret.length()>r-l) {
                    ret = s.substring(l,r);
                }
                c = s.charAt(l);
                if (!counter.containsKey(c)) {
                    l++;
                    continue;
                }
                if (counter.get(c)>=0) {
                    total++;
                }
                counter.put(c, counter.get(c)+1);
                l++;
            }
        }
        return ret;
    }
}
