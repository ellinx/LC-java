package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Given a non-empty array of non-negative integers nums, the degree of this
 * array is defined as the maximum frequency of any one of its elements.
 * 
 * Your task is to find the smallest possible length of a (contiguous) subarray
 * of nums, that has the same degree as nums.
 * 
 * Example 1:
 * 
 * Input: [1, 2, 2, 3, 1] 
 * Output: 2 
 * Explanation: The input array has a degree of 2 because both elements 1 and 2 
 * appear twice. Of the subarrays that have the same degree: [1, 2, 2, 3, 1], 
 * [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2] 
 * The shortest length is 2. So return 2.
 * 
 * Example 2:
 * 
 * Input: [1,2,2,3,1,4,2] 
 * Output: 6
 * 
 * Note: nums.length will be between 1 and 50,000. nums[i] will be an integer
 * between 0 and 49,999.
 * 
 * @author Ellinx
 *
 */
public class DegreeOfAnArray {
	public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> numIndexMap = new HashMap<>();
        int degree = 0;
        int ret = nums.length;
        
        for (int i=0;i<nums.length;i++) {
            if (!numIndexMap.containsKey(nums[i])) {
                numIndexMap.put(nums[i], new ArrayList<Integer>());
            }
            numIndexMap.get(nums[i]).add(i);
            degree = Math.max(degree, numIndexMap.get(nums[i]).size());
        }
        if (degree==1) {
            return 1;
        }
        for (int key : numIndexMap.keySet()) {
            if (numIndexMap.get(key).size()==degree) {
                ret = Math.min(ret, numIndexMap.get(key).get(degree-1)-numIndexMap.get(key).get(0)+1);
            }
        }
        return ret;
    }
}
