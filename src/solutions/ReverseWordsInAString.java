package solutions;

import java.util.Stack;

/**
Given an input string, reverse the string word by word.


Example 1:
Input: "the sky is blue"
Output: "blue is sky the"

Example 2:
Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:
Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space 
				in the reversed string.
 

Note:
1. A word is defined as a sequence of non-space characters.
2. Input string may contain leading or trailing spaces. 
	However, your reversed string should not contain leading or trailing spaces.
3. You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Follow up:
For C programmers, try to solve it in-place in O(1) extra space.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        Stack<String> stk = new Stack<>();
        int l=0, r=0;
        while (l<s.length()) {
            while (l<s.length() && s.charAt(l)==' ') {
                l++;
            }
            if (l==s.length()) {
                break;
            }
            r = l+1;
            while (r<s.length() && s.charAt(r)!=' ') {
                r++;
            }
            stk.push(s.substring(l,r));
            l = r;
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            if (sb.length()>0) {
                sb.append(" ");
            }
            sb.append(stk.pop());
        }
        return sb.toString();
    }
}
