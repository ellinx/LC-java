package solutions;

/**
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. 
You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:
Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].

Example 2:
Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */

public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m==0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ret = 0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                ret = Math.max(ret, dfs(matrix, i,j, dp));
            }
        }
        // for (int[] each:dp) {
        //     System.out.println(Arrays.toString(each));
        // }
        return ret;
    }
    private int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j]>0) {
            return dp[i][j];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        dp[i][j] = 1;
        for (int[] each:dirs) {
            int ni = i+each[0];
            int nj = j+each[1];
            if (ni>=0 && ni<m && nj>=0 && nj<n && matrix[ni][nj]>matrix[i][j]) {
                dp[i][j] = Math.max(dp[i][j],1+dfs(matrix,ni,nj,dp));
            }
        }
        return dp[i][j];
    }
}
