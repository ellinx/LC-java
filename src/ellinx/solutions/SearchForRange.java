package ellinx.solutions;

import java.util.Arrays;

/**
 * Given an array of integers sorted in ascending order, find the starting and
 * ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * @author Ellinx
 *
 */
public class SearchForRange {
	public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if (nums.length == 0) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        
        res[0] = lower_bound(nums, target);
        res[1] = upper_bound(nums, target);
        return res;
    }
	
	private int lower_bound(int[] nums, int target) {
		int start = 0;
		int end = nums.length-1;
		while (start < end) {
			int mid = start + (end - start) / 2;//mid is closer to left side if even number
			if (nums[mid]<target) {
				start = mid + 1;//safe and won't cross bound
			} else {
				end = mid;
			}
		}
		return (nums[start] == target) ? start : -1;
	}
	
	private int upper_bound(int[] nums, int target) {
		int start = 0;
		int end = nums.length-1;
		while (start < end) {
			int mid = start + (end - start + 1) / 2;//mid is close to right side if even number
			if (nums[mid]<=target) {
				start = mid;
			} else {
				end = mid - 1;//safe and won't cross bound
			}
		}
		return (nums[start] == target) ? start : -1;
	}
	
	//test
	public static void main(String[] args) {
		SearchForRange sfr = new SearchForRange();
		int[] nums = {5, 7, 7, 8, 8, 10};
		int[] result = sfr.searchRange(nums, 8);
		System.out.println(Arrays.toString(result));
	}
}
