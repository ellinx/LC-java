package ellinx.solutions;

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
        List<Integer> list = new ArrayList<>();
        for (int num:nums) {
            if (list.isEmpty()) {
                list.add(num);
                continue;
            }
            int index = 0;
            while (index<list.size()) {
                if (list.get(index)>=num) {
                    list.set(index, num);
                    break;
                }
                index++;
            }
            if (index==list.size())
                list.add(num);
        }
        return list.size();
    }
	
	//test
	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		int result = lis.lengthOfLIS(nums);
		System.out.println(result);
	}
}
