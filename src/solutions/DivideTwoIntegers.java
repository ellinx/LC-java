package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:
Input: dividend = 10, divisor = 3
Output: 3

Example 2:
Input: dividend = 7, divisor = -3
Output: -2

Note:
1. Both dividend and divisor will be 32-bit signed integers.
2. The divisor will never be 0.
3. Assume we are dealing with an environment which could only store integers 
	within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, 
	assume that your function returns 2^31 − 1 when the division result overflows.
 */

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        return myDivide((long)dividend, (long)divisor);
    }
    private int myDivide(long dividend, long divisor) {
        int sign = 1;
        //special cases
        if (dividend==0) {
            return 0;
        }
        //calculate final sign
        if ((dividend>0 && divisor<0) || (dividend<0 && divisor>0)) {
            sign = -1;
        }
        //convert to all positive number
        if (dividend<0) {
            dividend = -dividend;
        }
        if (divisor<0) {
            divisor = -divisor;
        }
        // System.out.println(dividend+","+divisor);
        //process
        List<Long> mm = new ArrayList<>();
        mm.add(divisor);
        long ret = 0L;
        while (dividend>=divisor) {
            //System.out.println(mm);
            while (dividend>mm.get(mm.size()-1)) {
                mm.add(mm.get(mm.size()-1)*2);
            }
            int idx = Collections.binarySearch(mm, dividend);
            if (idx>=0) {
                ret += 1L<<idx;
                break;
            }
            idx = -idx-2;
            ret += 1L<<idx;
            dividend -= mm.get(idx);
        }
        ret *= sign;
        if (ret>Integer.MAX_VALUE || ret<Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)ret;
    }
}
