package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
Design a class which receives a list of words in the constructor, 
and implements a method that takes two words word1 and word2 and 
return the shortest distance between these two words in the list. 
Your method will be called repeatedly many times with different parameters. 

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3

Input: word1 = "makes", word2 = "coding"
Output: 1

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */

public class ShortestWordDistanceII {
    
    private Map<String, List<Integer>> map;

    public ShortestWordDistanceII(String[] words) {
        map = new HashMap<>();
        for (int i=0;i<words.length;i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<Integer>());
            }
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int idx1=0, idx2=0;
        int ret = Integer.MAX_VALUE;
        while (idx1<l1.size() && idx2<l2.size()) {
            if (l1.get(idx1)<l2.get(idx2)) {
                ret = Math.min(ret, l2.get(idx2)-l1.get(idx1));
                idx1++;
            } else {
                ret = Math.min(ret, l1.get(idx1)-l2.get(idx2));
                idx2++;
            }
        }
        return ret;
    }
}
/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */