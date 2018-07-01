package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a binary array, find the maximum length of a contiguous subarray with
 * equal number of 0 and 1.
 * 
 * Example 1:
 * 
 * Input: [0,1] 
 * Output: 2 
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * 
 * Example 2:
 * 
 * Input: [0,1,0] 
 * Output: 2 
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * 
 * Note: The length of the given binary array will not exceed 50,000.
 * 
 *
 */
public class ContiguousArray {
	/**
	 * Thoughts:
	 * 1. convert this problem to be an array nums contains only -1 and 1, 
	 * 		find out longest contiguous subarray with sum to 0
	 * 2. similar idea like two sum
	 * 
	 * Time: O(n) where n is length of nums
	 * Space: O(n)
	 */
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> sumIndex = new HashMap<>();
        int ret = 0;
        int sum = 0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i]==0) {
                sum += -1;
            } else {
                sum += 1;
            }
            if (sum==0) {
                ret = Math.max(ret, i+1);
            } else {
                if (sumIndex.containsKey(sum)) {
                    ret = Math.max(ret, i-sumIndex.get(sum));
                } else {
                    sumIndex.put(sum, i);
                }
            }
        }
        return ret;
    }
}
