package ellinx.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * @author Ellinx
 *
 */
public class MajorityElement {
	public int majorityElementI(int[] nums) {
        int n = nums.length;
        int can = 0, count = 0;
        for (int i=0;i<n;i++) {
        	if (can==nums[i]) {
        		count++;
        	} else if (count==0) {
        		can = nums[i];
        		count = 1;
        	} else {
        		count--;
        	}
        }
        
        //no need to verify, as assume it always exists.
        return can;
    }
	
	public List<Integer> majorityElementII(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int n = nums.length;
        int can1 = 0, count1 = 0;
        int can2 = 1, count2 = 0;
        
        for (int i=0;i<n;i++) {
        	if (nums[i]==can1) {
        		count1++;
        	} else if (nums[i]==can2) {
        		count2++;
        	} else if (count1==0) {
        		can1 = nums[i];
        		count1 = 1;
        	} else if (count2==0) {
        		can2 = nums[i];
        		count2++;
        	} else {
        		count1--;
        		count2--;
        	}
        }
        
        count1 = 0;
        count2 = 0;
        for (int i=0;i<n;i++) {
        	if (can1==nums[i]) count1++;
        	if (can2==nums[i]) count2++;
        }
        
        if (count1>n/3) res.add(can1);
        if (count2>n/3) res.add(can2);
        
        return res;
    }
}
