package solutions;

import java.util.Stack;

/**
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), 
the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:
Input: "1 + 1"
Output: 2

Example 2:
Input: " 2-1 + 2 "
Output: 3

Example 3:
Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23

Note:
1. You may assume that the given expression is always valid.
2. Do not use the eval built-in library function.
 */
public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int l=0, r=0;
        int ret=0, sign=1;
        while (r<s.length()) {
            while (r<s.length() && s.charAt(r)==' ') {
                r++;
            }
            if (r==s.length()) {
                break;
            }
            if (s.charAt(r)=='+') {
                sign = 1;
                r++;
                l = r;
            } else if (s.charAt(r)=='-') {
                sign = -1;
                r++;
                l = r;
            } else if (s.charAt(r)=='(') {
                stk.push(ret);
                stk.push(sign);
                ret = 0;
                sign = 1;
                r++;
                l = r;
            } else if (s.charAt(r)==')') {
                int temp = ret;
                sign = stk.pop();
                ret = stk.pop();
                ret += sign*temp;
                r++;
                l = r;
            } else {
                l = r;
                r++;
                while (r<s.length() && s.charAt(r)>='0' && s.charAt(r)<='9') {
                    r++;
                }
                ret += sign*Integer.parseInt(s.substring(l,r));
                l = r;
            }
        }
        return ret;
    }
	
	//test 
	public static void main(String[] args) {
		BasicCalculator bc = new BasicCalculator();
		String s = "3+2-1";
		int result = bc.calculate(s);
		System.out.println(result);
	}
}
