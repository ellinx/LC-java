package ellinx.solutions;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Follow up: A rather straight forward solution is a two-pass algorithm using
 * counting sort. First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 * @author Ellinx
 *
 */
public class SortColors {
	public void sortColors(int[] nums) {
		int index0 = 0;
		int i = 0;
		int index2 = nums.length-1;
		
		while (i<=index2) {
			while (i<index2 && nums[i]==2) {
				nums[i] = nums[index2];
				nums[index2] = 2;
				index2--;
			}
			while (i>index0 && nums[i]==0) {
				nums[i] = nums[index0];
				nums[index0] = 0;
				index0++;
			}
			i++;
		}
	}
	
	//test
	public static void main(String[] args) {
		SortColors sc = new SortColors();
		int[] nums = {1,0,2,2,0,1};
		sc.sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
}
