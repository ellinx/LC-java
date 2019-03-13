package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
Given a collection of numbers that might contain duplicates, 
return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, new ArrayList<Integer>(), ret);
        return ret;
    }
    private void dfs(int[] nums, boolean[] used, List<Integer> cur, List<List<Integer>> ret) {
        if (nums.length==cur.size()) {
            ret.add(cur);
            return;
        }
        Set<Integer> pre = new HashSet<>();
        for (int i=0;i<nums.length;i++) {
            if (used[i] || pre.contains(nums[i])) {
                continue;
            }
            List<Integer> next = new ArrayList<>(cur);
            next.add(nums[i]);
            pre.add(nums[i]);
            used[i] = true;
            dfs(nums, used, next, ret);
            used[i] = false;
        }
    }
}
