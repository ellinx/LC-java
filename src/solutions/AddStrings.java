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
        String rnum1 = new StringBuilder(num1).reverse().toString();
        String rnum2 = new StringBuilder(num2).reverse().toString();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int carry = 0;
        while (index<Math.min(rnum1.length(),rnum2.length())) {
            int sum = rnum1.charAt(index)-'0'+rnum2.charAt(index)-'0'+carry;
            sb.append(sum%10);
            carry = sum/10;
            index++;
        }
        while (index<rnum1.length()) {
            int sum = rnum1.charAt(index)-'0'+carry;
            sb.append(sum%10);
            carry = sum/10;
            index++;
        }
        while (index<rnum2.length()) {
            int sum = rnum2.charAt(index)-'0'+carry;
            sb.append(sum%10);
            carry = sum/10;
            index++;
        }
        if (carry>0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
