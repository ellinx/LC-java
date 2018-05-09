package ellinx.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: 
 * [ [1,2,3], 
 *   [1,3,2],
 * 	 [2,1,3], 
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1] ]
 * 
 * @author Ellinx
 *
 */
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		if (nums.length==0) return new ArrayList<List<Integer>>();
        List<List<Integer>> res = help(nums, nums.length-1);
        return res;
    }
	
	private List<List<Integer>> help(int[] nums, int end) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> can = new ArrayList<>();
		if (0 == end) {
			can.add(nums[0]);
			res.add(can);
			return res;
		}
		
		for (int i=0;i<=end;i++) {
			int cur = nums[i];
			nums[i] = nums[end];
			nums[end] = cur;
			List<List<Integer>> tmp = help(nums, end-1);
			for (List<Integer> each : tmp) {
				each.add(cur);
				res.add(each);
			}
			nums[end] = nums[i];
			nums[i] = cur;
		}
		return res;
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
