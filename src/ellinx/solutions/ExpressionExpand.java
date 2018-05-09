package ellinx.solutions;

/**
 * Given an expression s includes numbers, letters and brackets. 
 * Number represents the number of repetitions inside the brackets(can be a string or another expression)．
 * Please expand expression to be a string.
 * 
 * Example
 * s = abc3[a] return abcaaa
 * s = 3[abc] return abcabcabc
 * s = 4[ac]dy, return acacacacdy
 * s = 3[2[ad]3[pf]]xyz, return adadpfpfpfadadpfpfpfadadpfpfpfxyz
 * 
 * @author Ellinx
 *
 */
public class ExpressionExpand {
	/*
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++) {
            char a = s.charAt(i);
            if (!Character.isDigit(a)) {
                sb.append(a);
                continue;
            }
            
            int digitStart = i;
            while (Character.isDigit(a)) {
                a = s.charAt(++i);
            }
            int num = Integer.parseInt(s.substring(digitStart,i));
            if (a=='[') {
                int k=i+1;
                int left=0;
                while (k<s.length()) {
                    if (s.charAt(k)=='[') {
                        left++;
                    }
                    if (s.charAt(k)==']') {
                        if (left==0) break;
                        left--;
                    }
                    k++;
                }
                String tmp = expressionExpand(s.substring(i+1,k));
                for (int n=0;n<num;n++) {
                    sb.append(tmp);
                }
                
                if (k+1==s.length()) {
                    return sb.toString();
                } else {
                    sb.append(expressionExpand(s.substring(k+1)));
                    return sb.toString();
                }
            }
        }
        return sb.toString();
    }
}
