package solutions;

/**
 * 
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * 
 * Note:
 * 
 * 1. The length of both num1 and num2 is < 5100. 
 * 2. Both num1 and num2 contains only digits 0-9. 
 * 3. Both num1 and num2 does not contain any leading zero. 
 * 4. You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 
 * @author Ellinx
 *
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int idx1=num1.length()-1, idx2=num2.length()-1;
        int carry = 0;
        while (idx1>=0 && idx2>=0) {
            int a = num1.charAt(idx1)-'0';
            int b = num2.charAt(idx2)-'0';
            int sum = a+b+carry;
            sb.append((sum%10)+"");
            carry = sum/10;
            idx1--;
            idx2--;
        }
        while (idx1>=0) {
            int a = num1.charAt(idx1)-'0';
            int sum = a+carry;
            sb.append((sum%10)+"");
            carry = sum/10;
            idx1--;
        }
        while (idx2>=0) {
            int b = num2.charAt(idx2)-'0';
            int sum = b+carry;
            sb.append((sum%10)+"");
            carry = sum/10;
            idx2--;
        }
        if (carry>0) {
            sb.append(carry+"");
        }
        return sb.reverse().toString();
    }
}
