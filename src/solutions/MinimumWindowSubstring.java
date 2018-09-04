package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * Example:
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC" 
 * Output: "BANC" 
 * 
 * Note:
 * 
 * If there is no such window in S that covers all characters in T, return the empty string "". 
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * 
 * @author Ellinx
 *
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char c:t.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0)+1);
        }
        int total = t.length();
        String ret = "";
        int start = 0, end = 0;
        while (end<s.length()) {
            if (counter.containsKey(s.charAt(end))) {
                int tmp = counter.get(s.charAt(end));
                if (tmp>0) {
                    total--;
                }
                counter.put(s.charAt(end), tmp-1);
                while (total==0) {
                    if (ret.length()==0 || ret.length()>end-start+1) {
                        ret = s.substring(start,end+1);
                    }
                    if (counter.containsKey(s.charAt(start))) {
                        tmp = counter.get(s.charAt(start));
                        if (tmp>=0) {
                            total++;
                        }
                        counter.put(s.charAt(start), tmp+1);
                    }
                    start++;
                }
            }
            end++;
        }
        return ret;
    }
}
