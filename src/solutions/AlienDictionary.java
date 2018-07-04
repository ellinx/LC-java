package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * There is a new alien language which uses the latin alphabet. 
 * However, the order among letters are unknown to you. 
 * You receive a list of non-empty words from the dictionary, 
 * where words are sorted lexicographically by the rules of this new language. 
 * Derive the order of letters in this language.
 * 
 * Example 1:
 * 
 * Input:
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 * 
 * Output: "wertf"
 * 
 * Example 2:
 * 
 * Input:
 * [
 *   "z",
 *   "x"
 * ]
 * 
 * Output: "zx"
 * 
 * Example 3:
 * 
 * Input:
 * [
 *   "z",
 *   "x",
 *   "z"
 * ] 
 * 
 * Output: "" 
 * 
 * Explanation: The order is invalid, so return "".
 * 
 * Note:
 * 
 * 1. You may assume all letters are in lowercase.
 * 2. You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 * 3. If the order is invalid, return an empty string.
 * 4. There may be multiple valid order of letters, return any one of them is fine.
 * 
 * 
 * @author Ellinx
 *
 */
public class AlienDictionary {
	/**
	 * Thoughts:
	 * 1. topology sort
	 */
    public String alienOrder(String[] words) {
        if (words.length==1) {
            return words[0];
        }
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (int i=0;i<words.length-1;i++) {
            int index = 0;
            boolean diff = false;
            while (index<Math.min(words[i].length(),words[i+1].length())) {
                char a = words[i].charAt(index);
                char b = words[i+1].charAt(index);
                indegree.put(a, indegree.getOrDefault(a,0));
                indegree.put(b, indegree.getOrDefault(b,0));
                if (!diff && a!=b) {
                    if (!map.containsKey(a)) {
                        map.put(a, new HashSet<Character>());
                    }
                    if (!map.get(a).contains(b)) {
                        map.get(a).add(b);
                        indegree.put(b, indegree.get(b)+1);
                    }
                    diff = true;
                }
                index++;
            }
            while (index<words[i].length()) {
                char a = words[i].charAt(index);
                indegree.put(a, indegree.getOrDefault(a,0));
                index++;
            }
            while (index<words[i+1].length()) {
                char a = words[i+1].charAt(index);
                indegree.put(a, indegree.getOrDefault(a,0));
                index++;
            }
        }
        Queue<Character> q = new LinkedList<>();
        for (char k:indegree.keySet()) {
            //System.out.println(k+":"+indegree.get(k));
            if (indegree.get(k)==0) {
                q.offer(k);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char c = q.poll();
            sb.append(c);
            //System.out.println(sb.toString());
            if (map.containsKey(c)) {
                for (char a:map.get(c)) {
                    indegree.put(a, indegree.get(a)-1);
                    if (indegree.get(a)==0) {
                        q.offer(a);
                    }
                }
            }
        }
        if (sb.length()!=indegree.size()) {
            return "";
        }
        return sb.toString();
    }
}
