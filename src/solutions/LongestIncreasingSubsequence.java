package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * For example, 
 * Given [10, 9, 2, 5, 3, 7, 101, 18], 
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
 * Note that there may be more than one LIS combination, it is only necessary for 
 * you to return the length.
 * 
 * Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 * @author Ellinx
 *
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length<=1) {
            return nums.length;
        }
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i=1;i<nums.length;i++) {
            int index = insertIndex(list, nums[i]);
            if (index==list.size()) {
                list.add(nums[i]);
            } else {
                list.set(index, nums[i]);
            }
        }
        return list.size();
    }
    
    private int insertIndex(List<Integer> list, int num) {
        int start=0, end=list.size()-1;
        while (start<=end) {
            int mid = start+(end-start)/2;
            if (list.get(mid)==num) {
                return mid;
            }
            if (list.get(mid)<num) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return start;
    }
	
	//test
	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		int result = lis.lengthOfLIS(nums);
		System.out.println(result);
	}
}
