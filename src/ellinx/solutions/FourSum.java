package ellinx.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSum {
	/**
	 * Given an array S of n integers, are there elements a, b, c, and d in S
	 * such that a + b + c + d = target? Find all unique quadruplets in the
	 * array which gives the sum of target.
	 * 
	 * Note: The solution set must not contain duplicate quadruplets.
	 * 
	 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
	 * 
	 * A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
	 *
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		int n = nums.length;
		if (n < 4)
			return res;
		Arrays.sort(nums);

		for (int i = 0; i < n - 3; i++) {
			if (i > 0 && nums[i - 1] == nums[i])
				continue;
			if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
				break;
			if (nums[n - 4] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target)
				break;

			for (int j = i + 1; j < n - 2; j++) {
				if (j > i + 1 && nums[j - 1] == nums[j])
					continue;
				if (nums[i] + nums[j] + nums[j + 1] + nums[j + 1] > target)
					break;
				if (nums[n - 4] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target)
					break;

				int left = j + 1;
				int right = n - 1;
				while (left < right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					if (sum < target) {
						left++;
					} else if (sum > target) {
						right--;
					} else {
						List<Integer> tmp = new ArrayList<>();
						tmp.add(nums[i]);
						tmp.add(nums[j]);
						tmp.add(nums[left]);
						tmp.add(nums[right]);
						res.add(tmp);
						do {
							left++;
						} while (nums[left - 1] == nums[left] && left < right);
						do {
							right--;
						} while (nums[right] == nums[right + 1] && left < right);
					}
				}
			}
		}
		return res;
	}

	/**
	 * Given four lists A, B, C, D of integer values, compute how many tuples
	 * (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
	 * 
	 * To make problem a bit easier, all A, B, C, D have same length of N where
	 * 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the
	 * result is guaranteed to be at most 2^31 - 1.
	 * 
	 * Example:
	 * 
	 * Input: A = [ 1, 2] B = [-2,-1] C = [-1, 2] D = [ 0, 2]
	 * 
	 * Output: 2
	 * 
	 * Explanation: The two tuples are: 
	 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0 
	 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
	 */
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        
        for (int a:A) {
        	for (int b:B) {
        		int sum = a+b;
        		if (map.containsKey(sum)) {
        			map.put(sum, map.get(sum)+1);
        		} else {
        			map.put(sum, 1);
        		}
        	}
        }
        
        for (int c:C) {
        	for (int d:D) {
        		int sum = c+d;
        		if (map.containsKey(-sum)) {
        			res += map.get(-sum);
        		}
        	}
        }
        return res;
    }
	

	// test
	public static void main(String[] args) {
		FourSum tmp = new FourSum();
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		List<List<Integer>> result1 = tmp.fourSum(nums, 0);
		for (List<Integer> each : result1) {
			System.out.println(each.toString());
		}
		
		int[] A = {1,2};
		int[] B = {-2,-1};
		int[] C = {-1,2};
		int[] D = {0,2};
		int result2 = tmp.fourSumCount(A, B, C, D);
		System.out.println(result2);
	}
}
