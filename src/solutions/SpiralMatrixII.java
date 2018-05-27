package solutions;

/**
 * 
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 * Example:
 * 
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * 
 * @author Ellinx
 *
 */
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        int curNum = 1;
        int[][] ret = new int[n][n];
        while (curNum<=n*n) {
            //left->right
            for (int i=colStart;i<=colEnd;i++) {
                ret[rowStart][i] = curNum++;
                if (curNum>n*n)
                    break;
            }
            rowStart++;
            if (curNum>n*n)
                break;
            //up->down
            for (int i=rowStart;i<=rowEnd;i++) {
                ret[i][colEnd] = curNum++;
                if (curNum>n*n)
                    break;
            }
            colEnd--;
            if (curNum>n*n)
                break;
            //right->left
            for (int i=colEnd;i>=colStart;i--) {
                ret[rowEnd][i] = curNum++;
                if (curNum>n*n)
                    break;
            }
            rowEnd--;
            if (curNum>n*n)
                break;
            //down->up
            for (int i=rowEnd;i>=rowStart;i--) {
                ret[i][colStart] = curNum++;
                if (curNum>n*n)
                    break;
            }
            colStart++;
        }
        return ret;
    }
}
