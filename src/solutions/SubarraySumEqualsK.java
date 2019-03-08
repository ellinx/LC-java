package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * 
 * Example 1: 
 * Input:nums = [1,1,1], k = 2 
 * Output: 2 
 * 
 * Note: The length of the array is in range [1, 20,000]. The range of numbers
 * in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 * 
 * @author Ellinx
 *
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> counter = new HashMap<>();
        counter.put(0,1);
        int total = 0;
        int ret = 0;
        for (int num:nums) {
            total += num;
            ret += counter.getOrDefault(total-k, 0);
            counter.put(total, counter.getOrDefault(total,0)+1);
        }
        return ret;
    }
	
	//test
	public static void main(String[] args) {
		SubarraySumEqualsK ssek = new SubarraySumEqualsK();
		int[] nums = {1,1,1};
		int result = ssek.subarraySum(nums, 2);
		System.out.println(result);
	}
}
