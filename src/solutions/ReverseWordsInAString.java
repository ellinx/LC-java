package solutions;

import java.util.Stack;

/**
 * 
 * Given an input string, reverse the string word by word.
 * 
 * Example:
 * 
 * Input: "the sky is blue", 
 * Output: "blue is sky the".
 * 
 * Note:
 * 
 * 1. A word is defined as a sequence of non-space characters. 
 * 2. Input string may contain leading or trailing spaces. 
 * 		However, your reversed string should not contain leading or trailing spaces. 
 * 3. You need to reduce multiple spaces between two words to a single space in the reversed string.
 * 
 * @author Ellinx
 *
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        Stack<String> stk = new Stack<>();
        int index = 0;
        while (index<s.length()) {
            while (index<s.length() && s.charAt(index)==' ') {
                index++;
            }
            if (index==s.length()) {
                break;
            }
            int end = index+1;
            while (end<s.length() && s.charAt(end)!=' ') {
                end++;
            }
            stk.push(s.substring(index,end));
            index = end+1;
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop()).append(' ');
        }
        if (sb.length()==0) {
            return "";
        }
        return sb.substring(0,sb.length()-1);
    }
}
