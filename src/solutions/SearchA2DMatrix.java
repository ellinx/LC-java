package solutions;

/**
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row.
 * 
 * Example 1:
 * Input: 
 * matrix = [ 
 * 				[1, 3, 5, 7], 
 * 				[10, 11, 16, 20], 
 * 				[23, 30, 34, 50] 
 * 			] 
 * target = 3 
 * Output: true
 * 
 * Example 2:
 * Input: matrix = [ 
 * 						[1, 3, 5, 7], 
 * 						[10, 11, 16, 20], 
 * 						[23, 30, 34, 50] 
 * 					] 
 * target = 13 
 * Output: false
 * 
 * 
 *
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m<1) {
            return false;
        }
        int n = matrix[0].length;
        if (n<1) {
            return false;
        }
        int start = 0;
        int end = m-1;
        while (start<=end) {
            int mid = start+(end-start)/2;
            if (matrix[mid][0]==target) {
                return true;
            }
            if (matrix[mid][0]<target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        if (start==0) {
            return false;
        }
        int row = start-1;
        //System.out.println(row);
        start = 0;
        end = n-1;
        while (start<=end) {
            int mid = start+(end-start)/2;
            if (matrix[row][mid]==target) {
                return true;
            }
            if (matrix[row][mid]<target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return false;
    }
}
