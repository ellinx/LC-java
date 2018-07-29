package solutions;

/**
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * 
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * Example 1:
 * 
 * Input: m = 3, n = 2 
 * Output: 3 
 * Explanation: 
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner: 
 * 1. Right -> Right -> Down 
 * 2. Right -> Down -> Right 
 * 3. Down -> Right -> Right
 * 
 * Example 2:
 * 
 * Input: m = 7, n = 3 
 * Output: 28
 * 
 * 
 * @author Ellinx
 *
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m<=0 || n<=0) {
            return 0;
        }
        int[] cur = new int[n];
        for (int i=0;i<n;i++) {
            cur[i] = 1;
        }
        for (int i=1;i<m;i++) {
            int[] next = new int[n];
            for (int k=0;k<n;k++) {
                if (k==0) {
                    next[0] = 1;
                    continue;
                }
                next[k] = next[k-1]+cur[k];
            }
            cur = next;
        }
        return cur[n-1];
    }
}
