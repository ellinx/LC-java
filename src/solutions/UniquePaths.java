package solutions;

import java.util.Arrays;

/**
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

start x x x x x x
x     x x x x x x
x     x x x x x finish

Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

Example 2:
Input: m = 7, n = 3
Output: 28
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] cur = new int[m];
        Arrays.fill(cur, 1);
        for (int i=1;i<n;i++) {
            int[] next = new int[m];
            next[0] = 1;
            for (int j=1;j<m;j++) {
                next[j] = next[j-1]+cur[j];
            }
            cur = next;
        }
        return cur[m-1];
    }
}
