package solutions;

import java.util.HashSet;
import java.util.Set;

/**
Given a non-empty 2D array grid of 0's and 1's, 
an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) 
You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. 
An island is considered to be the same as another if and only if one island can be translated 
(and not rotated or reflected) to equal the other.

Example 1:
11000
11000
00011
00011
Given the above grid map, return 1.

Example 2:
11011
10000
00001
11011
Given the above grid map, return 3.

Notice that:
11
1
and
 1
11
are considered different island shapes, because we do not consider reflection / rotation.

Note: The length of each dimension in the given grid does not exceed 50.
 */

public class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        if (m==0) {
            return 0;
        }
        int n = grid[0].length;
        Set<String> shapeSet = new HashSet<>();
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j]==1) {
                    shapeSet.add(dfs(grid,i,j,""));
                }
            }
        }
        // for (String s:shapeSet) {
        //     System.out.println(s);
        // }
        return shapeSet.size();
    }
    private String dfs(int[][] grid, int i, int j, String shape) {
        grid[i][j] = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int idx=0;idx<dirs.length;idx++) {
            int ni = i+dirs[idx][0];
            int nj = j+dirs[idx][1];
            if (ni>=0 && ni<m && nj>=0 && nj<n && grid[ni][nj]==1) {
                if (idx==0) {
                    shape += "u";
                } else if (idx==1) {
                    shape += "d";
                } else if (idx==2) {
                    shape += "l";
                } else {
                    shape += "r";
                }
                shape += dfs(grid,ni,nj,"");
            }
        }
        return shape+"b";
    }
}
