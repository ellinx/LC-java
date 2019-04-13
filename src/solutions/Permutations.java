package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        for (int i=0;i<nums.length;i++) {
            used[i] = true;
            dfs(nums, used, Arrays.asList(nums[i]), ret);
            used[i] = false;
        }
        return ret;
    }
    private void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> ret) {
        if (list.size()==nums.length) {
            ret.add(list);
            return;
        }
        for (int i=0;i<nums.length;i++) {
            if (!used[i]) {
                used[i] = true;
                List<Integer> next = new ArrayList<>(list);
                next.add(nums[i]);
                dfs(nums, used, next, ret);
                used[i] = false;
            }
        }
    }
	
	//test
	public static void main(String[] args) {
		Permutations tmp = new Permutations();
		int[] nums = {1,2,3};
		List<List<Integer>> result = tmp.permute(nums);
		for (List<Integer> each : result) {
			System.out.println(each.toString());
		}
	}
}
