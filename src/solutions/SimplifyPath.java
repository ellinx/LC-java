package solutions;

import java.util.Stack;

/**
 * 
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example, 
 * path = "/home/", => "/home" 
 * path = "/a/./b/../../c/", => "/c"
 * 
 * Corner Cases:
 * 
 * Did you consider the case where path = "/../"? 
 * In this case, you should return "/". 
 * Another corner case is the path might contain multiple slashes '/' together, 
 * such as "/home//foo/". 
 * In this case, you should ignore redundant slashes and return "/home/foo".
 * 
 * 
 *
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Stack<String> stk = new Stack<>();
        for (String s:dirs) {
            if (s.equals("") || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (!stk.isEmpty()) {
                    stk.pop();
                }
            } else {
                stk.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s:stk) {
            sb.append("/").append(s);
        }
        if (sb.length()==0) {
            return "/";
        }
        return sb.toString();
    }
}
