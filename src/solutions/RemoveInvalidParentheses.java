package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. 
 * Return all possible results.
 * 
 * Note: The input string may contain letters other than the parentheses ( and ).
 * 
 * Example 1:
 * 
 * Input: "()())()" 
 * Output: ["()()()", "(())()"]
 * 
 * Example 2:
 * 
 * Input: "(a)())()" 
 * Output: ["(a)()()", "(a())()"]
 * 
 * Example 3:
 * 
 * Input: ")(" 
 * Output: [""]
 * 
 * 
 * @author Ellinx
 *
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0;
        int r = 0;
        for (char c:s.toCharArray()) {
            if (c=='(') {
                l++;
            } else if (c==')') {
                if (l==0) {
                    r++;
                } else {
                    l--;
                }
            }
        }
        List<String> ret = new ArrayList<>();
        dfs(s, 0, l, r, ret);
        return ret;
    }
    
    private void dfs(String s, int start,int l, int r, List<String> ret) {
        if (l==0 && r==0) {
            if (isValid(s)) {
                ret.add(s);
            }
            return;
        }
        if (l>0) {
            for (int i=start;i<s.length();i++) {
                if (s.charAt(i)=='(') {
                    if (i==0 || s.charAt(i-1)!='(') {
                        dfs(s.substring(0,i)+s.substring(i+1), i, l-1, r, ret);
                    }
                }
            }
        }
        if (r>0) {
            for (int i=start;i<s.length();i++) {
                if (s.charAt(i)==')') {
                    if (i==0 || s.charAt(i-1)!=')') {
                        dfs(s.substring(0,i)+s.substring(i+1), i, l, r-1, ret);
                    }
                }
            }
        }
    }
    
    private boolean isValid(String s) {
        int l = 0;
        for (char c:s.toCharArray()) {
            if (c=='(') {
                l++;
            } else if (c==')') {
                if (l==0) {
                    return false;
                } else {
                    l--;
                }
            }
        }
        return l==0;
    }
}
