package ellinx.solutions;

import java.util.Arrays;

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of
 * the matrix in diagonal order as shown in the below image.
 * 
 * Example: 
 * Input: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] 
 * Output:
 * [1,2,4,7,5,3,6,8,9] 
 * 
 * Explanation:
 * 
 * Note: The total number of elements of the given matrix will not exceed
 * 10,000.
 * 
 * @author Ellinx
 *
 */
public class DiagonalTraverse {
	public int[] findDiagonalOrder(int[][] matrix) {
        int row = matrix.length;
        if (row==0) return new int[0];
        
        int col = matrix[0].length;
        int[] res = new int[col*row];
        int index = 0;
        for (int i=0;i<row+col-1;i++) {
        	if (i%2==0) {
        		//from left-bottom to right-top
        		int x = (i<row)?0:(i-row+1);
        		int y = (i<row)?i:(row-1);
        		while (x<col && y>=0) {
        			res[index++] = matrix[y--][x++];
        		}
        	} else {
        		//from right-top to left-bottom
        		int x = (i<col)?i:(col-1);
        		int y = (i<col)?0:(i-col+1);
        		while (x>=0 && y<row) {
        			res[index++] = matrix[y++][x--];
        		}
        	}
        }
  
        return res;
    }
	
	//test
	public static void main(String[] args) {
		DiagonalTraverse tmp = new DiagonalTraverse();
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		int[] result = tmp.findDiagonalOrder(matrix);
		System.out.println(Arrays.toString(result));
	}
}
