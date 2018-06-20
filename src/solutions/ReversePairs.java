package solutions;

import java.util.Arrays;

/**
 * 
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 * 
 * You need to return the number of important reverse pairs in the given array.
 * 
 * Example1:
 * 
 * Input: [1,3,2,3,1] Output: 2
 * 
 * Example2:
 * 
 * Input: [2,4,3,5,1] Output: 3
 * 
 * Note:
 * 
 * 1. The length of the given array will not exceed 50,000. 
 * 2. All the numbers in the input array are in the range of 32-bit integer.
 * 
 *
 */
public class ReversePairs {
    private int totalReversePairs = 0;
    
    //idea similar to merge sort
    public int reversePairs(int[] nums) {
        if (nums.length<2) {
            return 0;
        }
        helper(nums);
        return totalReversePairs;
    }
    
    private int[] helper(int[] nums) {
        if (nums.length==1) {
            return nums;
        }
        int mid = (nums.length-1)/2;
        int[] left = helper(Arrays.copyOfRange(nums, 0, mid+1));
        int[] right = helper(Arrays.copyOfRange(nums, mid+1, nums.length));
        //check reverse pair
        int j=0;
        for (int i=0;i<left.length;i++) {
            for (;j<right.length;j++) {
                if ((long)(left[i])<=(long)(right[j])*2) {
                    break;
                }
            }
            totalReversePairs += j;
        }
        //merge
        int[] ret = new int[nums.length];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1<left.length && index2<right.length) {
            if (left[index1]<right[index2]) {
                ret[index++] = left[index1++];
            } else if (left[index1]>right[index2]) {
                ret[index++] = right[index2++];
            } else {
                ret[index++] = left[index1++];
                ret[index++] = right[index2++];
            }
        }
        while (index1<left.length) {
            ret[index++] = left[index1++];
        }
        while (index2<right.length) {
            ret[index++] = right[index2++];
        }
        return ret;
    }
}
