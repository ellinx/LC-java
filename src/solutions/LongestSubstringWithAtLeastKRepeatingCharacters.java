package solutions;

import java.util.HashMap;
import java.util.Map;

/**
Find the length of the longest substring T of a given string (consists of lowercase letters only) 
such that every character in T appears no less than k times.

Example 1:
Input:
s = "aaabb", k = 3
Output:
3
The longest substring is "aaa", as 'a' is repeated 3 times.

Example 2:
Input:
s = "ababbc", k = 2
Output:
5
The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        if (s.length()<k) {
            return 0;
        }
        Map<Character,Integer> counter = new HashMap<>();
        for (char c:s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c,0)+1);
        }
        char leastChar = s.charAt(0);
        int least = counter.get(leastChar);
        for (char c:counter.keySet()) {
            if (least>counter.get(c)) {
                least = counter.get(c);
                leastChar = c;
            }
        }
        if (least>=k) {
            return s.length();
        }
        // System.out.println(Character.toString(leastChar)+","+least+","+s);
        int ret = 0;
        for (String each:s.split(Character.toString(leastChar))) {
            ret = Math.max(ret, longestSubstring(each,k));
        }
        return ret;
    }
}
