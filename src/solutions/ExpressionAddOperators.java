package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string that contains only digits 0-9 and a target value, return all
 * possibilities to add binary operators (not unary) +, -, or * between the
 * digits so they evaluate to the target value.
 * 
 * Example 1:
 * Input: num = "123", target = 6 
 * Output: ["1+2+3", "1*2*3"] 
 * 
 * Example 2:
 * Input: num = "232", target = 8 
 * Output: ["2*3+2", "2+3*2"] 
 * 
 * Example 3:
 * Input: num = "105", target = 5 
 * Output: ["1*0+5","10-5"] 
 * 
 * Example 4:
 * Input: num = "00", target = 0 
 * Output: ["0+0", "0-0", "0*0"] 
 * 
 * Example 5:
 * Input: num = "3456237490", target = 9191 
 * Output: []
 * 
 * @author Ellinx
 *
 */
public class ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
        List<String> ret = new ArrayList<>();
        dfs(num, "", target, 0, 0, 0, ret);
        return ret;
    }
    
    private void dfs(String num, String pre, int target, long preVal, int start, long mul, List<String> ret) {
        if (start==num.length()) {
            if (preVal==target)
                ret.add(pre);
            return;
        }
        int end = start;
        if (num.charAt(end)=='0') {
            if (start==0) {
                dfs(num, "0", target, preVal, start+1, mul, ret);
            } else {
                dfs(num, pre+"+0", target, preVal, start+1, 0, ret);
                dfs(num, pre+"-0", target, preVal, start+1, 0, ret);
                dfs(num, pre+"*0", target, preVal-mul, start+1, 0, ret);
            }
            return;
        }
        while (end<num.length()) {
            String curStr = num.substring(start,end+1);
            long curNum = Long.parseLong(curStr);
            if (start==0) {
                dfs(num, curStr, target, curNum, end+1, curNum, ret);
            } else {
                dfs(num, pre+"+"+curStr, target, preVal+curNum, end+1, curNum, ret);
                dfs(num, pre+"-"+curStr, target, preVal-curNum, end+1, (-1)*curNum, ret);
                dfs(num, pre+"*"+curStr, target, preVal-mul+mul*curNum, end+1, mul*curNum, ret);
            }
            end++;
        }
    }
}
