package ellinx.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ContainsDuplicate {
	
	/**
	 * Given an array of integers, find if the array contains any duplicates. 
	 * Your function should return true if any value appears at least twice in the array, 
	 * and it should return false if every element is distinct.
	 *
	 */
	public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i=1;i<nums.length;i++) {
        	if (nums[i]==nums[i-1]) return true;
        }
        return false;
    }
	
	
	/**
	 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array 
	 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> numSet = new HashSet<Integer>(nums.length);
        for (int i=0;i<nums.length;i++) {
        	if (i>k) {
        		numSet.remove(nums[i-k-1]);
        	}
        	if (numSet.contains(nums[i])) return true;
        	
        	numSet.add(nums[i]);
        }
        return false;
    }
	
	
	/**
	 * Given an array of integers, find out whether there are two distinct indices i and j in the array 
	 * such that the absolute difference between nums[i] and nums[j] is at most t 
	 * and the absolute difference between i and j is at most k.
	 */
	
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k<1 || t<0) return false;
        Map<Long, Long> map = new HashMap<Long, Long>();
        for (int i=0;i<nums.length;i++) {
        	if (i>k) {
        		long tmp = (long)nums[i-k-1]-Integer.MIN_VALUE;
        		tmp /= (long)t+1;
        		map.remove(tmp);
        	}
        	long val = (long)nums[i]-Integer.MIN_VALUE;
        	long bucket = val/((long)t+1);
        	System.out.println("val="+val+",bucket="+bucket);
        	System.out.println("same bucket:"+map.containsKey(bucket));
        	if (map.containsKey(bucket) || (map.containsKey(bucket-1) && val-map.get(bucket-1)<=t) 
        			|| (map.containsKey(bucket+1) && map.get(bucket+1)-val<=t)) {
        		return true;
        	}
        	map.put(bucket, val);
        }
        return false;
    }
	
	//test
	public static void main(String[] args) {
		ContainsDuplicate tmp = new ContainsDuplicate();
		int[] nums = {1, 3, 1};
		boolean result = tmp.containsNearbyAlmostDuplicate(nums, 1, 1);
		System.out.println(result);
	}
	
}
