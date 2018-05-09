package ellinx.solutions;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example, 
 * 
 * Given [1,2,0] return 3, 
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * @author Ellinx
 *
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
        int index = 0;
        while (index<nums.length) {
            int cur = nums[index];
            if (cur>0 && cur<=nums.length && cur!=index+1 && nums[cur-1]!=cur) {
                int temp = nums[cur-1];
                nums[cur-1] = cur;
                nums[index] = temp;
            } else {
                index++;
            }
        }
        //System.out.println(Arrays.toString(nums));
        index = 0;
        while (index<nums.length) {
            if (nums[index]!=index+1)
                return index+1;
            
            index++;
        }
        return index+1;
    }
	
	//test
	public static void main(String[] args) {
		FirstMissingPositive fmp = new FirstMissingPositive();
		int[] nums = {3,4,-1,1};
		int result = fmp.firstMissingPositive(nums);
		System.out.println(result);
	}
}
