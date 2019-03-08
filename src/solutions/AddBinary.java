package solutions;

/**
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int idx1=a.length()-1, idx2=b.length()-1;
        int carry = 0;
        while (idx1>=0 && idx2>=0) {
            int n1 = a.charAt(idx1)-'0';
            int n2 = b.charAt(idx2)-'0';
            int sum = n1+n2+carry;
            sb.append((sum%2)+"");
            carry = sum/2;
            idx1--;
            idx2--;
        }
        while (idx1>=0) {
            int n1 = a.charAt(idx1)-'0';
            int sum = n1+carry;
            sb.append((sum%2)+"");
            carry = sum/2;
            idx1--;
        }
        while (idx2>=0) {
            int n2 = b.charAt(idx2)-'0';
            int sum = n2+carry;
            sb.append((sum%2)+"");
            carry = sum/2;
            idx2--;
        }
        if (carry>0) {
            sb.append(carry+"");
        }
        return sb.reverse().toString();
    }
}
