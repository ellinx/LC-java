package solutions;

import java.util.Stack;

/**
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], 
where the encoded_string inside the square brackets is being repeated exactly k times. 
Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; 
No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and 
that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stk = new Stack<>();
        int repeat = 1;
        int l=0, r=0;
        while (l<s.length()) {
            if (s.charAt(l)=='[') {
                stk.push(sb.toString());
                stk.push(Integer.toString(repeat));
                repeat = 1;
                sb = new StringBuilder();
                l++;
            } else if (s.charAt(l)==']') {
                repeat = Integer.parseInt(stk.pop());
                String temp = sb.toString();
                sb = new StringBuilder(stk.pop());
                for (int i=0;i<repeat;i++) {
                    sb.append(temp);
                }
                l++;
            } else if (s.charAt(l)>='0' && s.charAt(l)<='9') {
                r = l+1;
                while (s.charAt(r)>='0' && s.charAt(r)<='9') {
                    r++;
                }
                repeat = Integer.parseInt(s.substring(l,r));
                l = r;
            } else {
                sb.append(s.charAt(l));
                l++;
            }
        }
        return sb.toString();
    }
}
