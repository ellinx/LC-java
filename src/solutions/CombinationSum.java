package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<>();
        dfs(candidates, 0, new ArrayList<Integer>(), 0, target, ret);
        return ret;
    }
    private void dfs(int[] candidates, int start, List<Integer> cur, int curSum, int target, List<List<Integer>> ret) {
        if (curSum==target) {
            ret.add(cur);
            return;
        }
        for (int i=start;i<candidates.length;i++) {
            if (curSum+candidates[i]>target) {
                break;
            }
            List<Integer> next = new ArrayList<>(cur);
            next.add(candidates[i]);
            dfs(candidates, i, next, curSum+candidates[i], target, ret);
        }
    }
}
