package ellinx.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * 
 * Output:
 * [5,6]
 * @author Ellinx
 *
 */
public class FindAllNumbersDisappearedInArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        
        // put 1-n into a set
        for (int i=0;i<nums.length;i++) {
        	set.add(i+1);
        }
        
        //remove number in nums from set
        for (int i=0;i<nums.length;i++) {
        	if (set.contains(nums[i])) {
        		set.remove(nums[i]);
        	}
        }
        
        //put integers which is not in nums to result
        for (Integer i : set) {
        	res.add(i);
        }
        
        return res;
        
    }
}
