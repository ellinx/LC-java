package solutions;

/**

Given a 2D binary matrix filled with 0's and 1's, 
find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
 */

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m==0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ret = 0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (matrix[i][j]=='1') {
                    //System.out.println(i+","+j+"="+matrix[i][j]);
                    dp[i][j] = 1;
                    if (i-1>=0 && j-1>=0 && dp[i-1][j-1]>0) {
                        int len = dp[i-1][j-1];
                        int offset = 1;
                        while (i-offset>=0 && matrix[i-offset][j]=='1') {
                            offset++;
                        }
                        len = Math.min(len, offset-1);
                        offset = 1;
                        while (j-offset>=0 && matrix[i][j-offset]=='1') {
                            offset++;
                        }
                        len = Math.min(len, offset-1);
                        dp[i][j] = len+1;
                    }
                    ret = Math.max(ret, dp[i][j]);
                }
            }
        }
        return ret*ret;
    }
}
