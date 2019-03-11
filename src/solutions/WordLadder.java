package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
Given two words (beginWord and endWord), and a dictionary's word list, 
find the length of shortest transformation sequence from beginWord to endWord, 
such that:

1. Only one letter can be changed at a time.
2. Each transformed word must exist in the word list. 
	Note that beginWord is not a transformed word.

Note:
1. Return 0 if there is no such transformation sequence.
2. All words have the same length.
3. All words contain only lowercase alphabetic characters.
4. You may assume no duplicates in the word list.
5. You may assume beginWord and endWord are non-empty and are not the same.

Example 1:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Example 2:
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        wordSet.remove(beginWord);
        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                String cur = q.poll();
                for (String s:getNeighbors(cur, wordSet)) {
                    if (s.equals(endWord)) {
                        return step+1;
                    }
                    q.offer(s);
                }
            }
            step++;
        }
        return 0;
    }
    private List<String> getNeighbors(String s, Set<String> wordSet) {
        List<String> ret = new ArrayList<>();
        char[] arr = s.toCharArray();
        for (int i=0;i<arr.length;i++) {
            char ori = arr[i];
            for (int j=0;j<26;j++) {
                char replace = (char)('a'+j);
                if (replace==ori) {
                    continue;
                }
                arr[i] = replace;
                String next = new String(arr);
                if (wordSet.contains(next)) {
                    wordSet.remove(next);
                    ret.add(next);
                }
            }
            arr[i] = ori;
        }
        return ret;
    }
}
