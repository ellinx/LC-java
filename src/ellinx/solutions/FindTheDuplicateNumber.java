package ellinx.solutions;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * Note:
 * 1.You must not modify the array (assume the array is read only).
 * 2.You must use only constant, O(1) extra space.
 * 3.Your runtime complexity should be less than O(n^2).
 * 4.There is only one duplicate number in the array, but it could be repeated more than once.
 * @author Ellinx
 *
 */
public class FindTheDuplicateNumber {
	public int findDuplicate(int[] nums) {
        int start = 1;
        int end = nums.length-1;
        int count = 0;
        
        while (start < end) {
        	int mid = (end-start)/2 + start;
        	count = 0;
        	for (int num : nums) {
        		if (num>mid && num<=end) {
        			count++;
        		}
        	}
        	//System.out.println("start="+start+",end="+end+",mid="+mid+",count="+count);
        	if (count>(end-start+1)/2) {
        		start = mid+1;
        	} else {
        		end = mid;
        	}
        }
        return start;
    }
	
	//test
	public static void main(String[] args) {
		FindTheDuplicateNumber tmp = new FindTheDuplicateNumber();
		int[] nums = {1,2,3,2};
		int result = tmp.findDuplicate(nums);
		System.out.println(result);
	}
}
