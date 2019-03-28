package solutions;

/**

Given a non-empty 2D array grid of 0's and 1's, 
an island is a group of 1's (representing land) connected 4-directionally 
(horizontal or vertical.) 

You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. 
(If there is no island, the maximum area is 0.)

Example 1:
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. 
Note the answer is not 11, because the island must be connected 4-directionally.

Example 2:
[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.

Note: The length of each dimension in the given grid does not exceed 50.
 */

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        if (m==0) {
            return 0;
        }
        int n = grid[0].length;
        int ret = 0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j]==1) {
                    ret = Math.max(ret, dfs(grid,i,j));
                }
            }
        }
        return ret;
    }
    private int dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        int ret = 1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int[] each:dirs) {
            int ni = i+each[0];
            int nj = j+each[1];
            if (ni>=0 && ni<m && nj>=0 && nj<n && grid[ni][nj]==1) {
                ret += dfs(grid,ni,nj);
            }
        }
        return ret;
    }
}
