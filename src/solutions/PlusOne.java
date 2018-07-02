package solutions;

import java.util.Arrays;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus
 * one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 1:
 * 
 * Input: [1,2,3] 
 * Output: [1,2,4] 
 * Explanation: The array represents the integer 123.
 * 
 * Example 2:
 * 
 * Input: [4,3,2,1] 
 * Output: [4,3,2,2] 
 * Explanation: The array represents the integer 4321.
 * 
 * 
 * @author Ellinx
 *
 */
public class PlusOne {
	/**
	 * Time: O(n) where n is length of digits
	 * Space: O(n)
	 */
    public int[] plusOne(int[] digits) {
        int[] ret = new int[digits.length+1];
        int carry = 1;
        for (int i=digits.length-1;i>=0;i--) {
            int sum = digits[i]+carry;
            carry = sum/10;
            ret[i+1] = sum%10;
        }
        if (carry==1) {
            ret[0] = 1;
            return ret;
        }
        return Arrays.copyOfRange(ret,1,ret.length);
    }
}
