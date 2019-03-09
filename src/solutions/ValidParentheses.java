package solutions;

import java.util.Stack;

/**
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order.
 * 
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * Input: "()" 
 * Output: true
 * 
 * Example 2:
 * 
 * Input: "()[]{}" 
 * Output: true
 * 
 * Example 3:
 * 
 * Input: "(]" 
 * Output: false
 * 
 * Example 4:
 * 
 * Input: "([)]" 
 * Output: false
 * 
 * Example 5:
 * 
 * Input: "{[]}" 
 * Output: true
 * 
 * 
 * @author Ellinx
 *
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (char c:s.toCharArray()) {
            if (c=='(' || c=='[' || c=='{') {
                stk.push(c);
            } else if (c==')') {
                if (!stk.empty() && stk.peek()=='(') {
                    stk.pop();
                } else {
                    return false;
                }
            } else if (c==']') {
                if (!stk.empty() && stk.peek()=='[') {
                    stk.pop();
                } else {
                    return false;
                }
            } else if (c=='}') {
                if (!stk.empty() && stk.peek()=='{') {
                    stk.pop();
                } else {
                    return false;
                }
            }
        }
        return stk.empty();
    }
}
