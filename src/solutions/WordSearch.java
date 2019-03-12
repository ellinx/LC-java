package solutions;

/**
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 

The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */
public class WordSearch {
	/**
	 * Thoughts:
	 * 1. for each position, do DFS search
	 * 
	 * Time: O(m*n*4^len) where m, n is row and col of board and len is length of word
	 * Space: O(1)
	 */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m==0) {
            return false;
        }
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (dfs(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int i, int j, String word, int start, boolean[][] visited) {
        if (word.charAt(start)!=board[i][j]) {
            return false;
        }
        if (start+1==word.length()) {
            return true;
        }
        visited[i][j] = true;
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int[] each:dirs) {
            int ni = i+each[0];
            int nj = j+each[1];
            if (ni>=0 && ni<m && nj>=0 && nj<n && !visited[ni][nj]) {
                if (dfs(board, ni, nj, word, start+1, visited)) {
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }
}
