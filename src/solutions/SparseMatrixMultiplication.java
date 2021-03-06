package solutions;

/**
Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

Input:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]

Output:

     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
 */

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = B[0].length;
        int[][] ret = new int[m][n];
        for (int i=0;i<m;i++) {
            for (int k=0;k<A[i].length;k++) {
                if (A[i][k]==0) {
                    continue;
                }
                for (int j=0;j<n;j++) {
                    ret[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        return ret;
    }
}
