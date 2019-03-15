package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
Given two arrays, write a function to compute their intersection.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]

Note:
1. Each element in the result must be unique.
2. The result can be in any order.
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num:nums1) {
            set.add(num);
        }
        List<Integer> common = new ArrayList<>();
        for (int num:nums2) {
            if (set.contains(num)) {
                common.add(num);
                set.remove(num);
            }
        }
        int[] ret = new int[common.size()];
        for (int i=0;i<common.size();i++) {
            ret[i] = common.get(i);
        }
        return ret;
    }
}
