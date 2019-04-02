package solutions;

/**
Given a string, determine if it is a palindrome, 
considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, 
we define empty string as valid palindrome.

Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:
Input: "race a car"
Output: false
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int l=0, r=s.length()-1;
        while (l<r) {
            while (l<r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (r>l && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (l>=r) {
                break;
            }
            if (Character.toUpperCase(s.charAt(l))!=Character.toUpperCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
