package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
Given a list of words (without duplicates), 
please write a program that returns all concatenated words in the given list of words.

A concatenated word is defined as a string that is 
comprised entirely of at least two shorter words in the given array.

Example:
Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
 "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".

Note:
1. The number of elements of the given array will not exceed 10,000
2. The length sum of elements in the given array will not exceed 600,000.
3. All the input string will only include lower case letters.
4. The returned elements order does not matter.
 */

public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ret = new ArrayList<>();
        Set<String> wordSet = new HashSet<>();
        Map<String,Boolean> mm = new HashMap<>();
        for (String word:words) {
            wordSet.add(word);
        }
        for (String word:words) {
            if (check(word, 0, wordSet, mm)) {
                ret.add(word);
            }
        }
        return ret;
    }
    private boolean check(String word, int start, Set<String> wordSet, Map<String,Boolean> mm) {
        String cur = word.substring(start);
        if (start>0) {
            if (wordSet.contains(cur)) {
                return true;
            }
        }
        if (mm.containsKey(cur)) {
            mm.get(cur);
        }
        for (int i=start+1;i<word.length();i++) {
            String w1 = word.substring(start,i);
            if (!wordSet.contains(w1)) {
                continue;
            }
            if (check(word, i, wordSet, mm)) {
                mm.put(word, true);
                return true;
            }
        }
        mm.put(word, false);
        return false;
    }
}
