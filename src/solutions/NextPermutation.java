package solutions;

import java.util.Arrays;

/**
Implement next permutation, which rearranges numbers into 
the lexicographically next greater permutation of numbers.

If such arrangement is not possible, 
it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. 
Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length<=1) {
            return;
        }
        int idx = nums.length-2;
        while (idx>=0 && nums[idx]>=nums[idx+1]) {
            idx--;
        }
        if (idx<0) {
            int l=0, r=nums.length-1;
            while (l<r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
            return;
        }
        int swap2 = nums.length-1;
        while (nums[idx]>=nums[swap2]) {
            swap2--;
        }
        int temp = nums[idx];
        nums[idx] = nums[swap2];
        nums[swap2] = temp;
        Arrays.sort(nums, idx+1, nums.length);
    }
}
