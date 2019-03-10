package solutions;

import java.util.ArrayList;
import java.util.List;

/**
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:
1. The same word in the dictionary may be reused multiple times in the segmentation.
2. You may assume the dictionary does not contain duplicate words.

Example 1:
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
             
Example 3:
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i=0;i<=n;i++) {
            if (dp[n]) {
                return true;
            }
            if (!dp[i]) {
                continue;
            }
            for (String word:wordDict) {
                int m = word.length();
                if (i+m<=n && s.substring(i,i+m).equals(word)) {
                    dp[i+m] = true;
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n];
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
		boolean result = wb.wordBreak(s, list);
		System.out.println("result is "+result);
	}
}
