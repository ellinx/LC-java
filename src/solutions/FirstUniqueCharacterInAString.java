package solutions;

import java.util.HashMap;
import java.util.Map;

/**
Given a string, find the first non-repeating character in it and return it's index. 
If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters.
 */

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character,Integer> counter = new HashMap<>();
        for (char c:s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c,0)+1);
        }
        for (int i=0;i<s.length();i++) {
            if (counter.get(s.charAt(i))==1) {
                return i;
            }
        }
        return -1;
    }
}
