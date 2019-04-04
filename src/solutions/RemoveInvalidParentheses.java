package solutions;

import java.util.ArrayList;
import java.util.List;

/**
Remove the minimum number of invalid parentheses in order to make the input string valid. 
Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:
Input: "()())()"
Output: ["()()()", "(())()"]

Example 2:
Input: "(a)())()"
Output: ["(a)()()", "(a())()"]

Example 3:
Input: ")("
Output: [""]
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int iLeft=0, iRight=0;
        for (char c:s.toCharArray()) {
            if (c=='(') {
                iLeft++;
            } else if (c==')') {
                if (iLeft==0) {
                    iRight++;
                } else {
                    iLeft--;
                }
            }
        }
        //System.out.println(iLeft+","+iRight);
        List<String> ret = new ArrayList<>();
        dfs(s,0,iLeft,iRight,ret);
        return ret;
    }
    private boolean isValid(String s) {
        int left=0;
        for (char c:s.toCharArray()) {
            if (c=='(') {
                left++;
            } else if (c==')') {
                left--;
                if (left<0) {
                    return false;
                }
            }
        }
        return left==0;
    }
    private void dfs(String s, int start, int il, int ir, List<String> ret) {
        //System.out.println(s+"--"+il+","+ir);
        if (il==0 && ir==0) {
            if (isValid(s)) {
                ret.add(s);
            }
            return;
        }
        if (il>0) {
            for (int i=start;i<s.length();i++) {
                if (s.charAt(i)=='(' && (i==0 || s.charAt(i-1)!='(')) {
                    dfs(s.substring(0,i)+s.substring(i+1), i, il-1, ir, ret);
                }
            }
        }
        if (ir>0) {
            for (int i=start;i<s.length();i++) {
                if (s.charAt(i)==')' && (i==0 || s.charAt(i-1)!=')')) {
                    dfs(s.substring(0,i)+s.substring(i+1), i, il, ir-1, ret);
                }
            }
        }
    }
}
