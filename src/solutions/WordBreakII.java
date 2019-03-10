package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
add spaces in s to construct a sentence where each word is a valid dictionary word. 

Return all such possible sentences.

Note:
1. The same word in the dictionary may be reused multiple times in the segmentation.
2. You may assume the dictionary does not contain duplicate words.

Example 1:
Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]

Example 2:
Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:
Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
 */

public class WordBreakII {
	public List<String> wordBreakII(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>();
        for (String str:wordDict) {
            set.add(str);
        }
        return DFS(s,set,new HashMap<String, List<String>>());
    }
	private List<String> DFS(String s, Set<String> set, Map<String, List<String>> map) {
        if (map.containsKey(s))
            return map.get(s);
        
        List<String> res = new LinkedList<>();
        for (int i=1;i<=s.length();i++) {
            String left = s.substring(0,i);
            if (set.contains(left)) {
                if (i<s.length()) {
                    List<String> right = DFS(s.substring(i), set, map);
                    if (!right.isEmpty()) {
                        for (String str:right) {
                            res.add(left+" "+str);
                        }
                    }
                } else {
                    res.add(left);
                }
            }
        }
        
        map.put(s, res);
        return res;
    }
}
