package solutions;

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
        int pre1 = -words.length;
        int pre2 = -words.length;
        int ret = Integer.MAX_VALUE;
        for (int i=0;i<words.length;i++) {
            if (word1.equals(words[i])) {
                if (i!=pre2) {
                    ret = Math.min(ret, i-pre2);
                }
                pre1 = i;
            }
            if (word2.equals(words[i])) {
                if (i!=pre1) {
                    ret = Math.min(ret, i-pre1);
                }
                pre2 = i;
            }
        }
        return ret;
    }
}
