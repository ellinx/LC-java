package ellinx.solutions;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements {

	/**
	 * Given a non-empty integer array of size n, find the minimum number of
	 * moves required to make all array elements equal, where a move is
	 * incrementing n - 1 elements by 1.
	 * 
	 * Example:
	 * 
	 * Input: [1,2,3]
	 * 
	 * Output: 3
	 * 
	 * Explanation: Only three moves are needed (remember each move increments
	 * two elements):
	 * 
	 * [1,2,3] => [2,3,3] => [3,4,3] => [4,4,4]
	 */
	public int minMoves(int[] nums) {
		// incrementing n - 1 elements by 1 <=> decrease 1 element by 1
		int res = 0;
		int min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			min = Math.min(min, nums[i]);
		}
		for (int num : nums) {
			res += num - min;
		}
		return res;
	}

	/**
	 * Given a non-empty integer array, find the minimum number of moves
	 * required to make all array elements equal, where a move is incrementing a
	 * selected element by 1 or decrementing a selected element by 1.
	 * 
	 * You may assume the array's length is at most 10,000.
	 * 
	 * Example:
	 * 
	 * Input: [1,2,3]
	 * 
	 * Output: 2
	 * 
	 * Explanation: Only two moves are needed (remember each move increments or
	 * decrements one element):
	 * 
	 * [1,2,3] => [2,2,3] => [2,2,2]
	 * 
	 */
	public int minMoves2(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        while (left<right) {
        	res += nums[right]-nums[left];
        	left++;
        	right--;
        }
        return res;
    }

	// test
	public static void main(String[] args) {
		MinimumMovesToEqualArrayElements tmp = new MinimumMovesToEqualArrayElements();
		int[] nums = { 1, 2, 3 };
		int result = tmp.minMoves2(nums);
		System.out.println(result);
	}
}
