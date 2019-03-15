package solutions;

/**
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
The integer division should truncate toward zero.

Example 1:
Input: "3+2*2"
Output: 7

Example 2:
Input: " 3/2 "
Output: 1

Example 3:
Input: " 3+5 / 2 "
Output: 5

Note:
1. You may assume that the given expression is always valid.
2. Do not use the eval built-in library function.
 */

public class BasicCalculatorII {
    public int calculate(String s) {
        int ret = 0;
        int last = 0;
        char sign = '+';
        int l=0, r= 0;
        while (r<s.length()) {
            while (r<s.length() && s.charAt(r)==' ') {
                r++;
            }
            if (r==s.length()) {
                break;
            }
            if (s.charAt(r)=='+') {
                sign = '+';
                r++;
                l = r;
            } else if (s.charAt(r)=='-') {
                sign = '-';
                r++;
                l = r;
            } else if (s.charAt(r)=='*') {
                sign = '*';
                r++;
                l = r;
            } else if (s.charAt(r)=='/') {
                sign = '/';
                r++;
                l = r;
            } else {
                l = r;
                r++;
                while (r<s.length() && s.charAt(r)>='0' && s.charAt(r)<='9') {
                    r++;
                }
                int num = Integer.parseInt(s.substring(l,r));
                if (sign=='+') {
                    ret += num;
                    last = num;
                } else if (sign=='-') {
                    ret -= num;
                    last = -num;
                } else if (sign=='*') {
                    ret = ret-last+last*num;
                    last = last*num;
                } else {
                    ret = ret-last+last/num;
                    last = last/num;
                }
                l = r;
            }
        }
        return ret;
    }
}
