package ellinx.solutions;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 * @author Ellinx
 *
 */
public class NumberOfBitOne {
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	int res=0;
    	// treat n as unsigned number
    	long num = Integer.toUnsignedLong(n);
        while (num!=0) {
        	res += num&1;
        	num >>= 1;
        }
        return res;
    }
    
}
