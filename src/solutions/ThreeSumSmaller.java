package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an array of n integers nums and a target, find the number of index
 * triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] +
 * nums[j] + nums[k] < target.
 * 
 * Example:
 * 
 * Input: nums = [-2,0,1,3], and target = 2 
 * Output: 2 
 * Explanation: Because there are two triplets which sums are less than 2: [-2,0,1] [-2,0,3]
 * 
 * Follow up: Could you solve it in O(n^2) runtime?
 * 
 * @author Ellinx
 *
 */
public class ThreeSumSmaller {
	private int total;
    
    public int threeSumSmaller(int[] nums, int target) {
        total = 0;
        dfs(nums, 0, new ArrayList<Integer>(), target);
        return total;
    }
    
    private void dfs(int[] nums, int start, List<Integer> cur, int target) {
        if (cur.size()==3) {
            int sum = 0;
            for (int each:cur) {
                sum += each;
            }
            if (sum<target) {
                total++;
            }
            return;
        }
        for (int i=start;i<nums.length-(2-cur.size());i++) {
            cur.add(nums[i]);
            dfs(nums, i+1, cur, target);
            cur.remove(cur.size()-1);
        }
    }
}
