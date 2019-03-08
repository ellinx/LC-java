package solutions;

/**
Given a list of words and two words word1 and word2, 
return the shortest distance between these two words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3

Input: word1 = "makes", word2 = "coding"
Output: 1

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */

public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int pre1=-words.length, pre2=-words.length;
        int ret = Integer.MAX_VALUE;
        for (int i=0;i<words.length;i++) {
            if (word1.equals(words[i])) {
                ret = Math.min(ret, i-pre2);
                pre1 = i;
            } else if (word2.equals(words[i])) {
                ret = Math.min(ret, i-pre1);
                pre2 = i;
            }
        }
        return ret;
    }
}
