package ellinx.solutions;

/**
 * Given a non-negative integer num represented as a string, remove k digits
 * from the number so that the new number is the smallest possible.
 * 
 * Note: The length of num is less than 10002 and will be ≥ k. The given num
 * does not contain any leading zero. 
 * 
 * Example 1:
 * 
 * Input: num = "1432219", k = 3 
 * Output: "1219" 
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest. 
 * 
 * Example 2:
 * 
 * Input: num = "10200", k = 1 
 * Output: "200" 
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * 
 * Example 3:
 * 
 * Input: num = "10", k = 2 
 * Output: "0" 
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * 
 * @author Ellinx
 *
 */
public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
        if (k==0) return num;
        if (num.length() <= k) return "0";
        
        int index0 = num.indexOf('0');
        if (index0 != -1) {
        	if (index0==k) {
        		String res = num.substring(index0+1);
        		res = (res.isEmpty())?"0":res;
        		return res;
        	}
        	
        	if (index0<k) {
        		return removeKdigits(num.substring(index0+1), k-index0);
        	}
        	
        	if (index0>k) {
        		String prefix = removeKdigits(num.substring(0, index0), k);
        		if (prefix=="0")
        			return num.substring(index0+1);
        		else
        			return prefix+num.substring(index0);
        	}
        }
        
        for (int i=0;i<num.length()-1;i++) {
        	if (num.charAt(i)>num.charAt(i+1)) {
        		String next = num.substring(0,i)+num.substring(i+1);
        		return removeKdigits(next, k-1);
        	}
        }
        
        return removeKdigits(num.substring(0,num.length()-1), k-1);
    }
	
	
	//test
	public static void main(String[] args) {
		RemoveKDigits tmp = new RemoveKDigits();
		String num = "212";
		String result = tmp.removeKdigits(num, 1);
		System.out.println(result);
	}
}
