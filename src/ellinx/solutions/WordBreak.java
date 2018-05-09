package ellinx.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {
	/**
	 * Given a non-empty string s and a dictionary wordDict containing a list of
	 * non-empty words, determine if s can be segmented into a space-separated
	 * sequence of one or more dictionary words. You may assume the dictionary
	 * does not contain duplicate words.
	 * 
	 * For example, given
	 * s = "leetcode", 
	 * dict = ["leet", "code"].
	 * 
	 * Return true because "leetcode" can be segmented as "leet code".
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
		int[] dp = new int[s.length()+1];
        Set<String> wordSet = new HashSet<>();
        //initialize dp array
        dp[0] = 1;
        //initialize word set
        for (String word : wordDict) {
            wordSet.add(word);
        }
        
        for (int end=0;end<s.length();end++) {
            for (int start=0;start<=end;start++) {
                if (dp[start]==1) {
                    String cur = s.substring(start, end+1);
                    if (wordSet.contains(cur)) {
                        dp[end+1] = 1;
                        break;
                    }
                }
            }
        }
        return (dp[s.length()]==1);
    }
	
	
	/**
	 * Given a non-empty string s and a dictionary wordDict containing a list of 
	 * non-empty words, add spaces in s to construct a sentence where each word 
	 * is a valid dictionary word. You may assume the dictionary does not contain 
	 * duplicate words.
	 * 
	 * Return all such possible sentences.
	 * 
	 * For example, given
	 * s = "catsanddog",
	 * dict = ["cat", "cats", "and", "sand", "dog"].
	 * 
	 * A solution is ["cats and dog", "cat sand dog"].
	 */
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
	
	//test
	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		String s = "catsanddog";
		List<String> list = new ArrayList<String>();
		list.add("cat");
		list.add("cats");
		list.add("sand");
		list.add("and");
		list.add("dog");
		List<String> result = wb.wordBreakII(s, list);
		//System.out.println("result is "+result);
		for (String str:result) {
			System.out.println(str);
		}
	}
}
