package solutions;

/**
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * Example:
 * 
 * board = 
 * [ 
 * 	['A','B','C','E'], 
 * 	['S','F','C','S'], 
 * 	['A','D','E','E'] 
 * ]
 * 
 * Given word = "ABCCED", return true. 
 * Given word = "SEE", return true. 
 * Given word = "ABCB", return false.
 * 
 * 
 *
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
        if (board.length==0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                if (dfs(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, String word, int start, boolean[][] visited) {
        //System.out.println("dfs:"+"i="+i+",j="+j+",start="+start);
        if (board[i][j]!=word.charAt(start)) {
            return false;
        }
        if (start+1==word.length()) {
            return true;
        }
        visited[i][j] = true;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int[] dir:dirs) {
            int row = i+dir[0];
            int col = j+dir[1];
            if (row>=0 && row<board.length && col>=0 && col<board[0].length && !visited[row][col] && board[row][col]==word.charAt(start+1)) {
                if (dfs(board, row, col, word, start+1, visited)) {
                    return true;
                }
            }
        }
        visited[i][j] = false;
        //System.out.println("out");
        return false;
    }
}
