package ellinx.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [ 
 * 	"((()))", 
 * 	"(()())", 
 * 	"(())()", 
 * 	"()(())", 
 * 	"()()()" ]
 * 
 * @author Ellinx
 *
 */
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, n, "", res);
        return res;
    }
    
    private void helper(int left, int right, String s, List<String> res) {
        if (left==0) {
            StringBuilder sb = new StringBuilder(s);
            for (int i=0;i<right;i++) {
                sb.append(')');
            }
            res.add(sb.toString());
            return;
        }
        
        helper(left-1, right, s+"(", res);
        if (left<right) {
            helper(left, right-1, s+")", res);
        }
    }
    
    //test
    public static void main(String[] args) {
    	GenerateParentheses gp = new GenerateParentheses();
    	List<String> result = gp.generateParenthesis(3);
    	System.out.println(result);
	}
}
