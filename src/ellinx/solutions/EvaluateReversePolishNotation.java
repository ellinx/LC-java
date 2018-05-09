package ellinx.solutions;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples: 
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * @author Ellinx
 *
 */
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
        	if (s.equals("+")) {
        		int num2 = stack.pop();
        		int num1 = stack.pop();
        		stack.push(num1+num2);
        	} else if (s.equals("-")) {
        		int num2 = stack.pop();
        		int num1 = stack.pop();
        		stack.push(num1-num2);
        	} else if (s.equals("*")) {
        		int num2 = stack.pop();
        		int num1 = stack.pop();
        		stack.push(num1*num2);
        	} else if (s.equals("/")) {
        		int num2 = stack.pop();
        		int num1 = stack.pop();
        		stack.push(num1/num2);
        	} else {
        		stack.push(Integer.parseInt(s));
        	}
        }
        return stack.peek();
    }
	
	//test
	public static void main(String[] args) {
		EvaluateReversePolishNotation tmp = new EvaluateReversePolishNotation();
		String[] tokens = {"0","3","/"};
		int result = tmp.evalRPN(tokens);
		System.out.println(result);
	}
}
