package ellinx.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example, If nums = [1,2,3], a solution is:
 * 
 * [ [3],
 *   [1],
 *   [2], 
 *   [1,2,3], 
 *   [1,3], 
 *   [2,3], 
 *   [1,2], 
 *   [] ]
 * 
 * @author Ellinx
 *
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        
        for (int num : nums) {
        	int length = res.size();
        	for (int i=0;i<length;i++) {
        		List<Integer> tmp = new ArrayList<Integer>(res.get(i));
        		tmp.add(num);
        		res.add(tmp);
        	}
        }
        return res;
    }
	
	//test
	public static void main(String[] args) {
		Subsets tmp = new Subsets();
		int[] nums = {1,2,3};
		List<List<Integer>> result = tmp.subsets(nums);
		for (List<Integer> each : result) {
			System.out.println(each.toString());
		}
	}
}
