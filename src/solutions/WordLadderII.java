package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
Given two words (beginWord and endWord), and a dictionary's word list, 
find all shortest transformation sequence(s) from beginWord to endWord, such that:

1. Only one letter can be changed at a time
2. Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:
1. Return an empty list if there is no such transformation sequence.
2. All words have the same length.
3. All words contain only lowercase alphabetic characters.
4. You may assume no duplicates in the word list.
5. You may assume beginWord and endWord are non-empty and are not the same.

Example 1:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]

Example 2:
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String,Set<String>> g = new HashMap<>();
        Map<String,Integer> dist = new HashMap<>();
        dist.put(beginWord,0);
        String letters = "abcdefghijklmnopqrstuvwxyz";
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-->0) {
                String cur = q.poll();
                for (int i=0;i<cur.length();i++) {
                    for (char c:letters.toCharArray()) {
                        if (c!=cur.charAt(i)) {
                            String next = cur.substring(0,i)+Character.toString(c)+cur.substring(i+1);
                            //System.out.println(next);
                            if (wordSet.contains(next)) {
                                if (!g.containsKey(cur)) {
                                    g.put(cur, new HashSet<String>());
                                }
                                g.get(cur).add(next);
                                if (!dist.containsKey(next)) {
                                    dist.put(next, step+1);
                                    q.offer(next);
                                }
                            }
                        }
                    }
                }
            }
            step++;
            if (dist.containsKey(endWord) && dist.get(endWord)<=step) {
                break;
            }
        }
        List<List<String>> ret = new ArrayList<>();
        if (!dist.containsKey(endWord)) {
            return ret;
        }
        dfs(g, dist, Arrays.asList(beginWord), endWord, ret);
        return ret;
    }
    private void dfs(Map<String,Set<String>> g, Map<String,Integer> dist, List<String> path, String endWord, List<List<String>> ret) {
        String cur = path.get(path.size()-1);
        if (cur.equals(endWord)) {
            ret.add(path);
            return;
        }
        if (g.containsKey(cur)) {
            for (String next:g.get(cur)) {
                if (dist.get(cur)+1==dist.get(next)) {
                    List<String> temp = new ArrayList<>(path);
                    temp.add(next);
                    dfs(g, dist, temp, endWord, ret);
                }
            }
        }
    }
}
