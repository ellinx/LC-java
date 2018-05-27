package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * 
 * Example 1:
 * 
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * Example 2:
 * 
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * @author Ellinx
 *
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        int rowStart = 0;
        int rowEnd = matrix.length-1;
        if (rowStart>rowEnd)
            return ret;
        int colStart = 0;
        int colEnd = matrix[0].length-1;
        if (colStart>colEnd)
            return ret;
        while (rowStart<=rowEnd && colStart<=colEnd) {
            //left->right
            for (int i=colStart;i<=colEnd;i++) {
                ret.add(matrix[rowStart][i]);
            }
            rowStart++;
            //up->down
            for (int i=rowStart;i<=rowEnd;i++) {
                ret.add(matrix[i][colEnd]);
            }
            colEnd--;
            //right->left
            if (rowStart<=rowEnd) {
                for (int i=colEnd;i>=colStart;i--) {
                    ret.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            } 
            if (colStart<=colEnd) {
                for (int i=rowEnd;i>=rowStart;i--) {
                    ret.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        return ret;
    }
}
