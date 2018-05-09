package ellinx.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * A magical string S consists of only '1' and '2' and obeys the following
 * rules:
 * 
 * The string S is magical because concatenating the number of contiguous
 * occurrences of characters '1' and '2' generates the string S itself.
 * 
 * The first few elements of string S is the following: S =
 * "1221121221221121122……"
 * 
 * If we group the consecutive '1's and '2's in S, it will be:
 * 
 * 1 22 11 2 1 22 1 22 11 2 11 22 ......
 * 
 * and the occurrences of '1's or '2's in each group are:
 * 
 * 1 2 2 1 1 2 1 2 2 1 2 2 ......
 * 
 * You can see that the occurrence sequence above is the S itself.
 * 
 * Given an integer N as input, return the number of '1's in the first N number
 * in the magical string S.
 * 
 * Note: N will not exceed 100,000.
 * 
 * Example 1: 
 * Input: 6 
 * Output: 3 
 * Explanation: The first 6 elements of magical
 * string S is "12211" and it contains three 1's, so return 3.
 * 
 * @author Ellinx
 *
 */
public class MagicalString {
	public int magicalString(int n) {
		if (n<=0) return 0;
		if (n<=3) return 1;
		if (n<=5) return 1+(n-3);
        List<Integer> ms = new ArrayList<>();
        int index = 0;
        int total = 0;
        ms.add(1);
        ms.add(2);
        ms.add(2);
        index = 2;
        total = 5;
        while (total<n) {
        	int nextElement = (ms.get(ms.size()-1)==1)?2:1;
        	for (int i=0;i<ms.get(index);i++) {
        		if (total+nextElement>=n) {
        			nextElement = n-total;
        		}
        		ms.add(nextElement);
        		total += nextElement;
        		if (total==n) break;
        	}
        	index++;
        }
        System.out.println(ms);
        int res = 0;
    	for (int i=0;i<ms.size();i+=2) {
    		res += ms.get(i);
    	}
    	return res;
    }
	
	//test
	public static void main(String[] args) {
		MagicalString tmp = new MagicalString();
		int result = tmp.magicalString(13);
		System.out.println(result);
	}
}
