package solutions;

/**
Given an input string , reverse the string word by word. 

Example:
Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]

Note: 
1. A word is defined as a sequence of non-space characters.
2. The input string does not contain leading or trailing spaces.
3. The words are always separated by a single space.

Follow up: Could you do it in-place without allocating extra space?
 */

public class ReverseWordsInAStringII {
    public void reverseWords(char[] str) {
        reverse(str, 0, str.length-1);
        int l=0, r=0;
        while (l<str.length) {
            while (r<str.length && str[r]!=' ') {
                r++;
            }
            reverse(str, l, r-1);
            r++;
            l = r;
        }
    }
    private void reverse(char[] str, int l, int r) {
        while (l<r) {
            char temp = str[l];
            str[l] = str[r];
            str[r] = temp;
            l++;
            r--;
        }
    }
}
