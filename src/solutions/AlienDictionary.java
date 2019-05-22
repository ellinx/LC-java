package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
There is a new alien language which uses the latin alphabet. 
However, the order among letters are unknown to you. 
You receive a list of non-empty words from the dictionary, 
where words are sorted lexicographically by the rules of this new language. 
Derive the order of letters in this language.

Example 1:
Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
Output: "wertf"

Example 2:
Input:
[
  "z",
  "x"
]
Output: "zx"

Example 3:
Input:
[
  "z",
  "x",
  "z"
] 
Output: "" 
Explanation: The order is invalid, so return "".

Note:
1. You may assume all letters are in lowercase.
2. You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
3. If the order is invalid, return an empty string.
4. There may be multiple valid order of letters, return any one of them is fine.
 */
public class AlienDictionary {
	/**
	 * Thoughts:
	 * 1. topology sort
	 */
    public String alienOrder(String[] words) {
        if (words.length==0) {
            return "";
        }
        if (words.length==1) {
            return words[0];
        }
        Map<Character,Set<Character>> g = new HashMap<>();
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);
        //construct graph
        for (int i=1;i<words.length;i++) {
            int idx = 0;
            while (idx<words[i-1].length() && idx<words[i].length()) {
                char c1 = words[i-1].charAt(idx);
                char c2 = words[i].charAt(idx);
                if (!g.containsKey(c1)) {
                    g.put(c1, new HashSet<Character>());
                    indegree[c1-'a'] = 0;
                }
                if (!g.containsKey(c2)) {
                    g.put(c2, new HashSet<Character>());
                    indegree[c2-'a'] = 0;
                }
                if (c1==c2) {
                    idx++;
                    continue;
                }
                if (!g.get(c1).contains(c2)) {
                    g.get(c1).add(c2);
                    indegree[c2-'a']++;
                }
                idx++;
                break;
            }
            for (int j=idx;j<words[i-1].length();j++) {
                char c = words[i-1].charAt(j);
                if (!g.containsKey(c)) {
                    g.put(c, new HashSet<Character>());
                    indegree[c-'a'] = 0;
                }
            }
            for (int j=idx;j<words[i].length();j++) {
                char c = words[i].charAt(j);
                if (!g.containsKey(c)) {
                    g.put(c, new HashSet<Character>());
                    indegree[c-'a'] = 0;
                }
            }
        }
        //topology sort
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for (int i=0;i<26;i++) {
            if (indegree[i]==0) {
                q.offer((char)('a'+i));
            }
        }
        while (!q.isEmpty()) {
            char c = q.poll();
            sb.append(c);
            for (char next:g.get(c)) {
                indegree[next-'a']--;
                if (indegree[next-'a']==0) {
                    q.offer(next);
                }
            }
        }
        for (int i=0;i<26;i++) {
            if (indegree[i]!=0 && indegree[i]!=-1) {
                return "";
            }
        }
        return sb.toString();
    }
}
