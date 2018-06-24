package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times.
 * 
 * Note: The algorithm should run in linear time and in O(1) space.
 * 
 * Example 1:
 * 
 * Input: [3,2,3] 
 * Output: [3]
 * 
 * Example 2:
 * 
 * Input: [1,1,1,3,3,2,2,2] 
 * Output: [1,2]
 * 
 * 
 */
public class MajorityElementII {
	/**
	 * Thoughts:
	 * 1. similar idea of solutions to Majority element I
	 * 2. use record two possible candidate
	 * 
	 * Time: O(n) where n is the length of the array
	 * Space: O(1)
	 */
    public List<Integer> majorityElement(int[] nums) {
        //similar idea of solutions to Majority element I.
        int i1 = 0, count1 = 0;
        int i2 = 1, count2 = 0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i]==nums[i1]) {
                count1++;
            } else if (nums[i]==nums[i2]) {
                count2++;
            } else {
                if (count1==0) {
                    i1 = i;
                    count1 = 1;
                } else if (count2==0) {
                    i2 = i;
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
            }
        }
        //check
        List<Integer> ret = new ArrayList<>();
        if (count1>0) {
            int total = 0;
            for (int i=0;i<nums.length;i++) {
                if (nums[i]==nums[i1]) {
                    total++;
                }
            }
            if (total>nums.length/3) {
                ret.add(nums[i1]);
            }
        }
        if (count2>0) {
            int total = 0;
            for (int i=0;i<nums.length;i++) {
                if (nums[i]==nums[i2]) {
                    total++;
                }
            }
            if (total>nums.length/3) {
                ret.add(nums[i2]);
            }
        }
        return ret;
    }
}
