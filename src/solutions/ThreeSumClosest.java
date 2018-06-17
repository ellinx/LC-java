package solutions;

import java.util.Arrays;

/**
 * 
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 
 * @author Ellinx
 *
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int ret = 0;
        for (int i=0;i<nums.length-2;i++) {
            int left = i+1;
            int right = nums.length-1;
            if (nums[i]+nums[left]+nums[left+1]>target) {
                if (diff>Math.abs(nums[i]+nums[left]+nums[left+1]-target)) {
                    diff = Math.abs(nums[i]+nums[left]+nums[left+1]-target);
                    ret = nums[i]+nums[left]+nums[left+1];
                }
                continue;
            }
            if (nums[i]+nums[right-1]+nums[right]<target) {
                if (diff>Math.abs(nums[i]+nums[right-1]+nums[right]-target)) {
                    diff = Math.abs(nums[i]+nums[right-1]+nums[right]-target);
                    ret = nums[i]+nums[right-1]+nums[right];
                }
                continue;
            }
            while (left<right) {
                int sum = nums[i]+nums[left]+nums[right];
                if (sum==target) {
                    return target;
                }
                if (diff>Math.abs(sum-target)) {
                    diff = Math.abs(sum-target);
                    ret = sum;
                }
                if (sum>target) {
                    right--;
                    while (right>left && nums[right]==nums[right+1]) {
                        right--;
                    }
                } else {
                    left++;
                    while (left<right && nums[left]==nums[left-1]) {
                        left++;
                    }
                }
            }
        }
        return ret;
    }
}
