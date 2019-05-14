package solutions;

/**
 Given an array of size n, find the majority element.
 The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.

 Example 1:
 Input: [3,2,3]
 Output: 3

 Example 2:
 Input: [2,2,1,1,1,2,2]
 Output: 2
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
	public int majorityElement(int[] nums) {
		int cand = nums[0];
		int count = 1;
		for (int i=1;i<nums.length;i++) {
			if (cand==nums[i]) {
				count++;
				continue;
			}
			if (count==0) {
				cand = nums[i];
				count++;
				continue;
			}
			count--;
		}
		return cand;
	}
}
