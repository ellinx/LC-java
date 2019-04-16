package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once in a word.


Example:
Input: 
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]
 

Note:
1. All inputs are consist of lowercase letters a-z.
2. The values of words are distinct.
 */
public class WordSearchII {
    class TrieNode {
        public boolean isWord;
        public TrieNode[] children;
        
        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }
    
    private TrieNode root;
    
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        for (String word:words) {
            insertWord(word);
        }
        int m = board.length;
        if (m==0) {
            return new ArrayList<String>();
        }
        int n = board[0].length;
        Set<String> ret = new HashSet<String>();
        boolean[][] visited = new boolean[m][n];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                searchWord(board, i, j, root, "", visited, ret);
            }
        }
        return new ArrayList<String>(ret);
    }
    private void insertWord(String word) {
        TrieNode node = root;
        for (char c:word.toCharArray()) {
            if (node.children[c-'a']==null) {
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isWord = true;
    }
    private void searchWord(char[][] board, int i, int j, TrieNode cur, String prefix, boolean[][] visited, Set<String> ret) {
        if (cur.children[board[i][j]-'a']==null) {
            return;
        }
        visited[i][j] = true;
        cur = cur.children[board[i][j]-'a'];
        String next = prefix+Character.toString(board[i][j]);
        if (cur.isWord) {
            ret.add(next);
        }
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int[] each:dirs) {
            int ni = i+each[0];
            int nj = j+each[1];
            if (ni>=0 && ni<m && nj>=0 && nj<n && !visited[ni][nj] ) {
                searchWord(board, ni, nj, cur, next, visited, ret);
            }
        }
        visited[i][j] = false;
    }
}
