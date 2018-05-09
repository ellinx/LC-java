package ellinx.solutions;

/**
 * Additive number is a string whose digits can form additive sequence.
 * 
 * A valid additive sequence should contain at least three numbers. 
 * Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * 
 * For example:
 * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * 
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * 
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 * 
 * Follow up:
 * How would you handle overflow for very large input integers?
 * 
 * @author Ellinx
 *
 */
public class AdditiveNumber {
	public boolean isAdditiveNumber(String num) {
		int n = num.length();
        if (n<3) return false;
        
        for (int i=1;i<n-1;i++) {
        	String num1 = num.substring(0, i);
        	for (int j=i+1;j<n;j++) {
        		String num2 = num.substring(i, j);
        		if (DFSCheck(num1, num2, j, num)) return true;
        	}
        }
        return false;
    }
	
	private boolean DFSCheck(String num1, String num2, int start, String num) {
		if ((num1.charAt(0)=='0' && num1.length()>1) || (num2.charAt(0)=='0' && num2.length()>1)) {
			return false;
		}
		
		String sum = strAdd(num1, num2);
		int n = sum.length();
		if (n>num.length()-start) {
			return false;
		}
		
		if (sum.equals(num.substring(start, start+n))) {
			if (start+n==num.length()) {
				return true;
			} else {
				return DFSCheck(num2, sum, start+n, num);
			}
		}
		return false;
	}
	
	private String strAdd(String s1, String s2) {
		StringBuilder sb = new StringBuilder();
		int a = 0, b = 0, c = 0;
		int index = 0;
		int n1 = s1.length();
		int n2 = s2.length();
		for (;index<Math.min(n1, n2);index++) {
			a = s1.charAt(n1-1-index)-'0';
			b = s2.charAt(n2-1-index)-'0';
			int sum = a+b+c;
			c = sum/10;
			sum %= 10;
			sb.insert(0, sum);
		}
		
		if (index<n1) {
			int size = n1-index-1;
			while (size>=0) {
				a = s1.charAt(size)-'0';
				b = 0;
				int sum = a+b+c;
				c = sum/10;
				sum %= 10;
				sb.insert(0, sum);
				size--;
			}
		} else if (index<n2) {
			int size = n2-index-1;
			while (size>=0) {
				a = s2.charAt(size)-'0';
				b = 0;
				int sum = a+b+c;
				c = sum/10;
				sum %= 10;
				sb.insert(0, sum);
				size--;
			}
		}
		
		if (c!=0) {
			sb.insert(0, c);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		AdditiveNumber tmp = new AdditiveNumber();
		boolean result = tmp.isAdditiveNumber("1203");
		System.out.println(result);
	}
}
