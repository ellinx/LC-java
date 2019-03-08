package solutions;

import java.util.ArrayList;
import java.util.List;

/**
Implement pow(x, n), which calculates x raised to the power n (x^n).

Example 1:
Input: 2.00000, 10
Output: 1024.00000

Example 2:
Input: 2.10000, 3
Output: 9.26100

Example 3:
Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

Note:
1. -100.0 < x < 100.0
2. n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 */

public class Pow {
    public double myPow(double x, int n) {
        return myPow(x, (long)n);
    }
    public double myPow(double x, long n) {
        if (n==0) {
            return 1;
        }
        if (n<0) {
            return 1/myPow(x,-n);
        }
        List<Double> power = new ArrayList<>();
        power.add(x);
        double ret = 1;
        while (n>0) {
            //System.out.println(ret+","+n);
            if (n<=(1L<<(power.size()-1))) {
                int idx = insertIdx(power, n);
                //System.out.println(idx);
                if (idx>=0) {
                    ret *= power.get(idx);
                    n -= (1L<<idx);
                } else {
                    ret *= power.get(-idx-1);
                    n -= (1L<<(-idx-1));
                }
                continue;
            }
            while (n>=(1L<<(power.size()-1))) {
                double last = power.get(power.size()-1);
                power.add(last*last);
            }
            ret *= power.get(power.size()-2);
            n -= (1L<<(power.size()-2));
        }
        //System.out.println(power);
        return ret;
    }
    private int insertIdx(List<Double> list, long n) {
        int l=0, r=list.size()-1;
        while (l<=r) {
            int m = l+(r-l)/2;
            long key = 1L<<m;
            if (key==n) {
                return m;
            }
            if (key>n) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return -l;
    }
}
