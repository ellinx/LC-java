package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts
 * array. The counts array has the property where counts[i] is the number of
 * smaller elements to the right of nums[i].
 * 
 * Example:
 * 
 * Input: [5,2,6,1] 
 * Output: [2,1,1,0] 
 * 
 * Explanation: 
 * To the right of 5 there are 2 smaller elements (2 and 1). 
 * To the right of 2 there is only 1 smaller element (1). 
 * To the right of 6 there is 1 smaller element (1). 
 * To the right of 1 there is 0 smaller element.
 * 
 */
public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if (nums.length==0) {
            return ret;
        }
        List<Integer> after = new ArrayList<>();
        for (int i=1;i<nums.length;i++) {
            after.add(nums[i]);
        }
        Collections.sort(after);
        for (int i=0;i<nums.length-1;i++) {
            int index = insertIndex(after, nums[i]);
            ret.add(index);
            after.remove(new Integer(nums[i+1]));
        }
        ret.add(0);
        return ret;
    }
    
    private int insertIndex(List<Integer> after, int target) {
        int start = 0;
        int end = after.size()-1;
        while (start<=end) {
            int mid = start+(end-start)/2;
            if (after.get(mid)==target) {
                if (mid-1>=0 && after.get(mid-1)==target) {
                    end = mid-1;
                } else {
                    return mid;
                }
            } else if (after.get(mid)<target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return start;
    }
}
