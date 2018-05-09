package ellinx.solutions;

import java.util.Stack;

public class BasicCalculator {
	/**
	 * Implement a basic calculator to evaluate a simple expression string.
	 * 
	 * The expression string may contain open ( and closing parentheses ), the plus
	 * + or minus sign -, non-negative integers and empty spaces .
	 * 
	 * You may assume that the given expression is always valid.
	 * 
	 * Some examples: 
	 * "1 + 1" = 2 
	 * " 2-1 + 2 " = 3 
	 * "(1+(4+5+2)-3)+(6+8)" = 23 
	 * 
	 * Note:
	 * Do not use the eval built-in library function.
	 * 
	 *
	 */
	public int calculateI(String s) {
		int number = 0;
        int res = 0;
        int sign = 1;
        int index = 0;
        
        while (index < s.length()) {
            char a = s.charAt(index);
            if (Character.isDigit(a)) {
                number = 10*number+(a-'0');
            } else if (a=='+') {
                res += sign*number;
                sign = 1;
                number = 0;
            } else if (a=='-') {
                res += sign*number;
                sign = -1;
                number = 0;
            } else if (a=='(') {
                int count = 0;
                int end = index+1;
                while (end < s.length()) {
                    char curChar = s.charAt(end);
                    if (curChar=='(')
                        count++;
                    else if (curChar==')') {
                        if (count>0)
                            count--;
                        else
                            break;
                    }
                    end++;
                }
                res += sign*calculateI(s.substring(index+1,end));
                sign = 1;
                number = 0;
                index = end;
            }
            index++;
        }
        res += sign*number;
        return res;
    }
	
	/**
	 * Implement a basic calculator to evaluate a simple expression string.
	 * 
	 * The expression string contains only non-negative integers, +, -, *, / operators 
	 * and empty spaces . The integer division should truncate toward zero.
	 * 
	 * You may assume that the given expression is always valid.
	 * 
	 * Some examples:
	 * "3+2*2" = 7
	 * " 3/2 " = 1
	 * " 3+5 / 2 " = 5
	 * Note: Do not use the eval built-in library function.
	 */
	public int calculateII(String s) {
		char sign = '+';
        int number = 0;
        int res = 0;
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        
        while (index <= s.length()) {
            if (index < s.length() && Character.isDigit(s.charAt(index))) {
                number = 10*number+(s.charAt(index)-'0');
            } else if (index == s.length() || s.charAt(index)=='+' || s.charAt(index)=='-' || s.charAt(index)=='*' || s.charAt(index)=='/') {
                switch(sign) {
                    case '+':
                        stack.push(number);
                        break;
                    case '-':
                        stack.push(-number);
                        break;
                    case '*':
                        stack.push(stack.pop()*number);
                        break;
                    case '/':
                        stack.push(stack.pop()/number);
                        break;
                    default:
                        System.out.println("unknown sign error!");
                        break;
                }
                if (index==s.length())
                    break;
                
                sign = s.charAt(index);
                number = 0;
            }
            index++;
        }
        
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
	
	//test 
	public static void main(String[] args) {
		BasicCalculator bc = new BasicCalculator();
		String s = "3+2*2";
		int result = bc.calculateII(s);
		System.out.println(result);
	}
}
