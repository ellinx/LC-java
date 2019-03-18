package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> mm = new HashMap<>();
        return dfs(s, 0, wordDict, mm);
    }
    private List<String> dfs(String s, int start, List<String> wordDict, Map<Integer, List<String>> mm) {
        if (s.length()==start) {
            return Arrays.asList("");
        }
        if (mm.containsKey(start)) {
            return mm.get(start);
        }
        List<String> ret = new ArrayList<>();
        for (String word:wordDict) {
            int n = word.length();
            if (start+n<=s.length() && s.substring(start,start+n).equals(word)) {
                for (String each:dfs(s, start+n, wordDict, mm)) {
                    if (each.length()==0) {
                        ret.add(word);
                    } else {
                        ret.add(word+" "+each);
                    }
                }
            }
        }
        mm.put(start, ret);
        return ret;
    }
}
