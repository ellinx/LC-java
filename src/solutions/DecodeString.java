package solutions;

import java.util.Stack;

/**
 * 
 * Given an encoded string, return it's decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * Examples:
 * 
 * s = "3[a]2[bc]", return "aaabcbc". 
 * s = "3[a2[c]]", return "accaccacc". 
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 * @author Ellinx
 *
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numStk = new Stack<>();
        Stack<String> strStk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index<s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int end = index+1;
                while (Character.isDigit(s.charAt(end))) {
                    end++;
                }
                numStk.push(Integer.parseInt(s.substring(index,end)));
                index = end;
            } else if (s.charAt(index)=='[') {
                strStk.push(sb.toString());
                sb = new StringBuilder();
                index++;
            } else if (s.charAt(index)==']') {
                int repeated = numStk.pop();
                StringBuilder next = new StringBuilder();
                for (int i=0;i<repeated;i++) {
                    next.append(sb.toString());
                }
                next.insert(0,strStk.pop());
                sb = next;
                index++;
            } else {
                sb.append(s.charAt(index));
                index++;
            }
        }
        return sb.toString();
    }
}
