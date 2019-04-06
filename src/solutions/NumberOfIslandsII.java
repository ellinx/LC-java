package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
A 2d grid map of m rows and n columns is initially filled with water. 
We may perform an addLand operation which turns the water at position (row, col) into a land. 
Given a list of positions to operate, count the number of islands after each addLand operation. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example:
Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
Output: [1,1,2,3]

Explanation:

Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0

Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0

Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0

Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0

Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0

Follow up:
Can you do it in time complexity O(k log mn), where k is the length of the positions?
 */

public class NumberOfIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] roots = new int[m*n+1];
        Arrays.fill(roots, -1);
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        List<Integer> ret = new ArrayList<>();
        int total = 0;
        for (int[] pos:positions) {
            if (roots[pos[0]*n+pos[1]+1]!=-1) {
                ret.add(total);
                continue;
            }
            total++;
            int root = findRoot(n, roots, pos);
            for (int[] each:dirs) {
                int i = pos[0]+each[0];
                int j = pos[1]+each[1];
                if (i>=0 && i<m && j>=0 && j<n && roots[i*n+j+1]!=-1) {
                    int root2 = findRoot(n, roots, new int[]{i,j});
                    if (root!=root2) {
                        roots[root2] = root;
                        total--;
                    }
                }
            }
            ret.add(total);
        }
        return ret;
    }
    private int findRoot(int n, int[] roots, int[] node) {
        int cur = node[0]*n+node[1]+1;
        if (roots[cur]==-1) {
            roots[cur] = cur;
            return cur;
        }
        while (cur!=roots[cur]) {
            cur = roots[cur];
        }
        return cur;
    }
}
