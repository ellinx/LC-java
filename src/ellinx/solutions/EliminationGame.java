package ellinx.solutions;

/**
 * There is a list of sorted integers from 1 to n. Starting from left to right,
 * remove the first number and every other number afterward until you reach the
 * end of the list.
 * 
 * Repeat the previous step again, but this time from right to left, remove the
 * right most number and every other number from the remaining numbers.
 * 
 * We keep repeating the steps again, alternating left to right and right to
 * left, until a single number remains.
 * 
 * Find the last number that remains starting with a list of length n.
 * 
 * Input: n = 9, 
 * 1 2 3 4 5 6 7 8 9 
 * 2 4 6 8 
 * 2 6 
 * 6
 * 
 * Output: 6
 *
 */
public class EliminationGame {
	public int lastRemaining(int n) {
        int start = 1;
        int step = 1;
        int size = n;
        boolean fromLeft = true;
        while (size>1) {
        	if (fromLeft) {
        		start += step;
        		size = size>>1;
        		step = step<<1;
        		fromLeft = false;
        	} else {
        		if (size%2==1) {
        			start += step;
        		}
        		size = size>>1;
        		step = step<<1;
        		fromLeft = true;
        	}
        }
        return start;
    }
	
	//test
	public static void main(String[] args) {
		EliminationGame tmp = new EliminationGame();
		int result = tmp.lastRemaining(10);
		System.out.println(result);
	}
}
