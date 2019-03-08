package solutions;

/**
Given an array of integers nums sorted in ascending order, 
find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1,-1};
        int l=0, r=nums.length-1;
        while (l<=r) {
            int m = l+(r-l)/2;
            if (nums[m]==target) {
                if (m-1>=l && nums[m-1]==target) {
                    r = m-1;
                    continue;
                }
                l = m;
                break;
            }
            if (nums[m]>target) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        if (l<nums.length && nums[l]==target) {
            ret[0] = l;
        } else {
            return ret;
        }
        l=0;
        r=nums.length-1;
        while (l<=r) {
            int m = l+(r-l)/2;
            if (nums[m]==target) {
                if (m+1<=r && nums[m+1]==target) {
                    l = m+1;
                    continue;
                }
                l = m;
                break;
            }
            if (nums[m]>target) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        ret[1] = l;
        return ret;
    }
}
