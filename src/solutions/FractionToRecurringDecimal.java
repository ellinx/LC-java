package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * Example 1:
 * 
 * Input: numerator = 1, denominator = 2 
 * Output: "0.5"
 * 
 * Example 2:
 * 
 * Input: numerator = 2, denominator = 1 
 * Output: "2"
 * 
 * Example 3:
 * 
 * Input: numerator = 2, denominator = 3 
 * Output: "0.(6)"
 * 
 * 
 * @author Ellinx
 *
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator==0) {
            return "0";
        }
        long A = numerator;
        long B = denominator;
        String sign = "";
        if (A<0 && B<0) {
            A = -A;
            B = -B;
        }
        if (A<0) {
            sign = "-";
            A = -A;
        }
        if (B<0) {
            sign = "-";
            B = -B;
        }
        StringBuilder sb = new StringBuilder();
        if (A>=B) {
            sb.append(A/B);
            A %= B;
        } else {
            sb.append(0);
        }
        if (A==0) {
            return sign+sb.toString();
        }
        sb.append('.');
        Map<Long,Integer> map = new HashMap<>();
        while (A!=0) {
            String temp = Long.toString(A*10/B);
            sb.append(temp);
            if (map.containsKey(A)) {
                return sign+sb.substring(0,map.get(A))+"("+sb.substring(map.get(A),sb.length()-temp.length())+")";
            }
            map.put(A, sb.length()-1);
            A = (A*10)%B;
        }
        return sign+sb.toString();
    }
}
