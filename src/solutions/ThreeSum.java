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
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i=0;i<n-2;i++) {
            if (nums[i]+nums[i+1]+nums[i+2]>0) {
                break;
            }
            if (i>0 && nums[i-1]==nums[i]) {
                continue;
            }
            if (nums[i]+nums[n-2]+nums[n-1]<0) {
                continue;
            }
            int j=i+1, k=n-1;
            while (j<k) {
                if (nums[i]+nums[j]+nums[k]==0) {
                    ret.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    while (j<k && nums[j-1]==nums[j]) {
                        j++;
                    }
                    k--;
                    while (k>j && nums[k]==nums[k+1]) {
                        k--;
                    }
                } else if (nums[i]+nums[j]+nums[k]>0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ret;
    }
}
