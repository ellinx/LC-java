package ellinx.solutions;

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
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            sum += nums[i];
            if (map.containsKey(sum-k)) {
                res += map.get(sum-k);
            }
            
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum)+1);
            } else {
                map.put(sum, 1);
            }
            //System.out.println("sum="+sum+",res="+res);
        }
        res += (map.containsKey(k))?map.get(k):0;
        return res;
    }
	
	//test
	public static void main(String[] args) {
		SubarraySumEqualsK ssek = new SubarraySumEqualsK();
		int[] nums = {1,1,1};
		int result = ssek.subarraySum(nums, 2);
		System.out.println(result);
	}
}
