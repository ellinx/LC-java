package ellinx.solutions;

import java.util.Arrays;

/**
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is
 * an extremely large positive integer given in the form of an array.
 * 
 * Example1:
 * a = 2 b = [3]
 * 
 * Result: 8 
 * 
 * Example2:
 * a = 2 b = [1,0]
 * 
 * Result: 1024
 * 
 * @author Ellinx
 *
 */
public class SuperPow {
	private final int MOD = 1337;
	//(ab)%k = (a%k)(b%k)%k
	public int superPow(int a, int[] b) {
        if (b.length==0) return 1;
        
        if (a==1) return 1;
        int lastDigit = b[b.length-1];
        if (b.length==1) {
        	b = new int[0];
        } else {
        	b = Arrays.copyOf(b, b.length-1);
        }
        return sPDigit(superPow(a, b), 10)*sPDigit(a, lastDigit)%MOD;
    }
	
	//0<=b<=10
	private int sPDigit(int a, int b) {
		if (a==1 || b==0) return 1;
		
		int res = a%MOD;
		b--;
		while (b!=0) {
			res = res*(a%MOD)%MOD;
			b--;
		}
		return res;
	}
	
	
	//test
	public static void main(String[] args) {
		SuperPow tmp = new SuperPow();
		int[] nums = {1,0};
		int result = tmp.superPow(2, nums);
		System.out.println(result);
	}
}
