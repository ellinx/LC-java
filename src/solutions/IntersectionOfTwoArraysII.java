package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2] 
 * Output: [2,2]
 * 
 * Example 2:
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] 
 * Output: [4,9]
 * 
 * Note:
 * 
 * Each element in the result should appear as many times as it shows in both
 * arrays. The result can be in any order.
 * 
 * Follow up:
 * 
 * What if the given array is already sorted? 
 * How would you optimize your algorithm? 
 * What if nums1's size is small compared to nums2's size? 
 * Which algorithm is better? 
 * What if elements of nums2 are stored on disk, and the memory is limited such that 
 * you cannot load all elements into the memory at once?
 * 
 * 
 * @author Ellinx
 *
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num:nums1) {
            counter.put(num, counter.getOrDefault(num, 0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num:nums2) {
            if (counter.containsKey(num)) {
                list.add(num);
                if (counter.get(num)==1) {
                    counter.remove(num);
                    continue;
                }
                counter.put(num, counter.get(num)-1);
            }
        }
        int[] ret = new int[list.size()];
        for (int i=0;i<list.size();i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
