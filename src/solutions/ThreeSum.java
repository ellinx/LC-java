package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * 
 * @author Ellinx
 *
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++) {
            if (nums[i]>0) {
                break;
            }
            if (i>0 && nums[i-1]==nums[i]) {
                continue;
            }
            int l = i+1;
            int r = nums.length-1;
            if (nums[i]+nums[l]+nums[l+1]>0) {
                break;
            }
            if (nums[i]+nums[r-1]+nums[r]<0) {
                continue;
            }
            while (l<r) {
                if (nums[i]+nums[l]+nums[r]==0) {
                    ret.add(Arrays.asList(new Integer[]{nums[i], nums[l], nums[r]}));
                    l++;
                    while (l<r && nums[l-1]==nums[l]) {
                        l++;
                    }
                    r--;
                    while (l<r && nums[r]==nums[r+1]) {
                        r--;
                    }
                } else if (nums[i]+nums[l]+nums[r]>0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ret;
    }
}
