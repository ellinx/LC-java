package ellinx.solutions;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author Ellinx
 *
 */
public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (target == nums[mid])
                return mid;
            
            if (nums[start]<nums[end]) {
                //normal
                if (nums[mid]<target) {
                    start = mid+1;
                } else if (nums[mid]>target) {
                    end = mid-1;
                }
            } else {
                //rotated
                if (nums[mid]<nums[start]) {
                    if (target>nums[end] || target<nums[mid]) {
                        end = mid-1;
                    } else {
                        start = mid+1;
                    }
                } else {
                    if (target<nums[start] || target>nums[mid]) {
                        start = mid+1;
                    } else {
                        end = mid-1;
                    }
                }
            }
        }
        return -1;
    }
	
	//test
	public static void main(String[] args) {
		SearchInRotatedSortedArray sirsa = new SearchInRotatedSortedArray();
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		int result = sirsa.search(nums, 5);
		System.out.println(result);
	}
}
