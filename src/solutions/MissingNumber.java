package solutions;

import java.util.Arrays;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find
 * the one that is missing from the array.
 * 
 * Example 1:
 * 
 * Input: [3,0,1] 
 * Output: 2
 * 
 * Example 2:
 * 
 * Input: [9,6,4,2,3,5,7,0,1] 
 * Output: 8
 * 
 * Note: 
 * Your algorithm should run in linear runtime complexity. 
 * Could you implement it using only constant extra space complexity?
 * 
 * 
 * @author Ellinx
 *
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int index = 0;
        while (index<nums.length) {
            if (nums[index]==index || nums[index]==nums.length) {
                index++;
                continue;
            }
            int temp = nums[index];
            nums[index] = nums[temp];
            nums[temp] = temp;
        }
        System.out.println(Arrays.toString(nums));
        int ret = -1;
        for (int i=0;i<nums.length;i++) {
            if (i!=nums[i]) {
                ret = i;
                break;
            }
        }
        if (ret==-1) {
            return nums.length;
        }
        return ret;
    }
}
