package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Write a function to generate the generalized abbreviations of a word.
 * 
 * Note: The order of the output does not matter.
 * 
 * Example:
 * 
 * Input: "word" Output: ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d",
 * "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * 
 * @author Ellinx
 *
 */
public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> ret = new ArrayList<>();
        dfs(word, 0, 0, "", ret);
        return ret;
    }
    
    private void dfs(String word, int start, int count, String cur, List<String> ret) {
        if (start==word.length()) {
            if (count!=0) {
                ret.add(cur+Integer.toString(count));
            } else {
                ret.add(cur);
            }
            return;
        }
        dfs(word, start+1, count+1, cur, ret);
        if (count!=0) {
            dfs(word, start+1, 0, cur+Integer.toString(count)+word.charAt(start), ret);
        } else {
            dfs(word, start+1, 0, cur+word.charAt(start), ret);
        }
    }
}
