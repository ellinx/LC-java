package ellinx.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct positive integers, find the largest subset such that
 * every pair (Si, Sj) of elements in this subset satisfies: 
 * Si % Sj = 0 or Sj % Si = 0.
 * 
 * If there are multiple solutions, return any subset is fine.
 * 
 * Example 1:
 * nums: [1,2,3]
 * 
 * Result: [1,2] (of course, [1,3] will also be ok) 
 * 
 * Example 2:
 * nums: [1,2,4,8]
 * 
 * Result: [1,2,4,8]
 * 
 * @author Ellinx
 *
 */
public class LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n==0) return new ArrayList<Integer>();
        List<Integer> res = null;
        List<List<Integer>> dp = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        
        List<Integer> tmp = new ArrayList<>();
        tmp.add(nums[0]);
        dp.add(tmp);
        res = dp.get(0);
        
        for (int i=1;i<n;i++) {
        	List<Integer> iSet = new ArrayList<>();
        	iSet.add(nums[i]);
        	dp.add(iSet);
        	for (int j=0;j<i;j++) {
        		List<Integer> checkSet = dp.get(j);
        		int minInSet = checkSet.get(0);
        		int maxInSet = checkSet.get(checkSet.size()-1);
        		if (nums[i]%minInSet==0 && nums[i]%maxInSet==0 && dp.get(i).size()-1<checkSet.size()) {
        			iSet = new ArrayList<>(checkSet);
        			iSet.add(nums[i]);
        			dp.set(i, iSet);
        		}
        	}
        	if (res.size()<dp.get(i).size()) {
        		res = dp.get(i);
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		LargestDivisibleSubset tmp = new LargestDivisibleSubset();
		int[] nums = {3,16,4,8};
		List<Integer> result = tmp.largestDivisibleSubset(nums);
		System.out.println(result.toString());
	}
}
