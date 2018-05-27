package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Given a list of words and two words word1 and word2, return the shortest
 * distance between these two words in the list.
 * 
 * word1 and word2 may be the same and they represent two individual words in
 * the list.
 * 
 * Example: Assume that words = ["practice", "makes", "perfect", "coding",
 * "makes"].
 * 
 * Input: word1 = “makes”, word2 = “coding” 
 * Output: 1 
 * 
 * Input: word1 = "makes", word2 = "makes" Output: 3 
 * 
 * Note: You may assume word1 and word2 are both in the list.
 * 
 * @author Ellinx
 *
 */
public class ShortestWordDistanceIII {
	public int shortestWordDistance(String[] words, String word1, String word2) {
        int ret = words.length;
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i=0;i<words.length;i++) {
            if (!map.containsKey(words[i]))
                map.put(words[i], new ArrayList<Integer>());
            map.get(words[i]).add(i);
        }
        if (word1.equals(word2)) {
            List<Integer> list = map.get(word1);
            int pre = -1;
            for (int each:list) {
                if (pre==-1) {
                    pre = each;
                    continue;
                }
                ret = Math.min(ret, each-pre);
                pre = each;
            }
            return ret;
        }
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int[] pre = {-1,-1};
        int i1=0,i2=0;
        while (i1<l1.size() && i2<l2.size()) {
            if (l1.get(i1)<l2.get(i2)) {
                if (pre[0]!=-1 && pre[0]==2) {
                    ret = Math.min(ret, l1.get(i1)-pre[1]);
                }
                pre = new int[]{1, l1.get(i1++)};
            } else {
                if (pre[0]!=-1 && pre[0]==1) {
                    ret = Math.min(ret, l2.get(i2)-pre[1]);
                }
                pre = new int[]{2, l2.get(i2++)};
            }
        }
        if (i1<l1.size()) {
            ret = Math.min(ret, l1.get(i1)-pre[1]);
        }
        if (i2<l2.size()) {
            ret = Math.min(ret, l2.get(i2)-pre[1]);
        }
        return ret;
    }
}
