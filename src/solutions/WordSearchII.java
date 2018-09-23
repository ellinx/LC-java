package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * 
 * Example:
 * 
 * Input: 
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * 
 * Output: ["eat","oath"]
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * @author Ellinx
 *
 */
public class WordSearchII {
	class Trie {
	    public boolean isWord;
	    public Trie[] children;
	    public Trie() {
	        isWord = false;
	        children = new Trie[26];
	    }
	}
	
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String word:words) {
            addWord(root, word);
        }
        List<String> ret = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                dfs(board, root, "", i, j, visited, ret);
            }
        }
        return ret;
    }
    
    private void dfs(char[][] board, Trie root, String cur, int i, int j, Set<Integer> visited, List<String> ret) {
        char c = board[i][j];
        if (root.children[c-'a']==null) {
            return;
        }
        Trie next = root.children[c-'a'];
        String nextStr = new StringBuilder(cur).append(c).toString();
        if (next.isWord) {
            next.isWord = false;
            ret.add(nextStr);
        }
        visited.add(i*board[0].length+j);
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int[] dir:dirs) {
            int ni = i+dir[0];
            int nj = j+dir[1];
            if (ni>=0 && ni<board.length && nj>=0 &&nj<board[0].length && !visited.contains(ni*board[0].length+nj)) {
                dfs(board, next, nextStr, ni, nj, visited, ret);
            }
        }
        visited.remove(i*board[0].length+j);
    }
    
    private void addWord(Trie root, String word) {
        for (int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if (root.children[c-'a']==null) {
                root.children[c-'a'] = new Trie();
            }
            root = root.children[c-'a'];
        }
        root.isWord = true;
    }
}
