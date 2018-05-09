package ellinx.solutions;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 * @author Ellinx
 *
 */
public class BitwiseANDofNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
		if (m==n) return m;
		
		return rangeBitwiseAnd(m>>1, n>>1)<<1;
    }
	
	//test
	public static void main(String[] args) {
		BitwiseANDofNumbersRange tmp = new BitwiseANDofNumbersRange();
		int res = tmp.rangeBitwiseAnd(5, 7);
		System.out.println(res);
	}
}
