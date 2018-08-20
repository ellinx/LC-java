package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2,2,1], 
 * nums2 = [2,2] 
 * Output: [2]
 * 
 * Example 2:
 * 
 * Input: nums1 = [4,9,5], 
 * nums2 = [9,4,9,8,4] 
 * Output: [9,4]
 * 
 * Note:
 * 
 * Each element in the result must be unique. 
 * The result can be in any order.
 * 
 * @author Ellinx
 *
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num:nums1) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>();
        for (int num:nums2) {
            if (set.contains(num)) {
                set.remove(num);
                list.add(num);
            }
        }
        int[] ret = new int[list.size()];
        for (int i=0;i<list.size();i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
