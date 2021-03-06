package solutions;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle 
 * defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * 
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), 
 * which contains sum = 8.
 * 
 * Example:
 * 
 * Given matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 * 
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * 
 * Note:
 * 
 * 1. You may assume that the matrix does not change.
 * 2. There are many calls to sumRegion function.
 * 3. You may assume that row1 ≤ row2 and col1 ≤ col2.

 * @author Ellinx
 *
 */
public class RangeSumQuery2D {
    private int[][] sum;
    
    public RangeSumQuery2D(int[][] matrix) {
        int m = matrix.length;
        if (m==0) {
            return;
        }
        int n = matrix[0].length;
        sum = new int[m][n];
        for (int i=0;i<n;i++) {
            if (i==0) {
                sum[0][i] = matrix[0][0];
                continue;
            }
            sum[0][i] = sum[0][i-1]+matrix[0][i];
        }
        for (int i=1;i<m;i++) {
            sum[i][0] = sum[i-1][0]+matrix[i][0];
        }
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                sum[i][j] = matrix[i][j]+sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1==0 && col1==0) {
            return sum[row2][col2];
        }
        if (row1==0) {
            return sum[row2][col2]-sum[row2][col1-1];
        }
        if (col1==0) {
            return sum[row2][col2]-sum[row1-1][col2];
        }
        return sum[row2][col2]-sum[row2][col1-1]-sum[row1-1][col2]+sum[row1-1][col1-1];
    }
}

/**
 * Your RangeSumQuery2D object will be instantiated and called as such:
 * RangeSumQuery2D obj = new RangeSumQuery2D(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
