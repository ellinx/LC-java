package solutions;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * @author Ellinx
 *
 */
public class MajorityElement {
	/**
	 * Thoughts:
	 * 1. Boyer-Moore Majority Vote algorithm
	 * 2. Whenever see a new number, record it.
	 * 3. if see this same number again, increase its count; if a different number, decrease its count. 
	 * 		If count is zero and see a different number, start record it as step 2
	 * 4. Verify the candidate. (optional if it exits)
	 * 
	 * Time: O(n) where n is length of array
	 * Space: O(1)
	 */
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
}
