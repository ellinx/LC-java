package solutions;

import java.util.Arrays;
import java.util.List;

/**
 * 
 *  A message containing letters from A-Z is being encoded to numbers using the following mapping way:
 *  
 *  'A' -> 1
 *  'B' -> 2
 *  ...
 *  'Z' -> 26
 *  
 *  Beyond that, now the encoded string can also contain the character '*', 
 *  which can be treated as one of the numbers from 1 to 9.
 *  
 *  Given the encoded message containing digits and the character '*', 
 *  return the total number of ways to decode it.
 *  
 *  Also, since the answer may be very large, you should return the output mod 109 + 7.
 *  
 *  Example 1:
 *  
 *  Input: "*"
 *  Output: 9
 *  Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
 *  
 *  Example 2:
 *  
 *  Input: "1*"
 *  Output: 9 + 9 = 18
 *  
 *  Note:
 *  
 *  1. The length of the input string will fit in range [1, 10^5].
 *  2. The input string will only contain the character '*' and digits '0' - '9'.
 *  
 * @author Ellinx
 *
 */
public class DecodeWaysII {
    public int numDecodings(String s) {
        long[] dp = new long[s.length()+1];
        dp[0] = 1;
        for (int i=1;i<dp.length;i++) {
            if (s.charAt(i-1)>='1' && s.charAt(i-1)<='9') {
                dp[i] += dp[i-1];
            } else if (s.charAt(i-1)=='*') {
                dp[i] += dp[i-1]*9;
            }
            dp[i] %= 1000000007;
            if (i-2>=0) {
                int total = 0;
                List<String> list = null;
                if (s.charAt(i-2)=='*') {
                    list = Arrays.asList(new String[]{"1","2"});
                } else if (s.charAt(i-2)=='1' || s.charAt(i-2)=='2') {
                    list = Arrays.asList(new String[]{Character.toString(s.charAt(i-2))});
                }
                if (list!=null) {
                    if (s.charAt(i-1)=='*') {
                        for (String each:list) {
                            if (each.equals("1")) {
                                total += 9;
                            } else if (each.equals("2")) {
                                total += 6;
                            }
                        }
                    } else {
                        for (String each:list) {
                            if (each.equals("1")) {
                                total += 1;
                            } else if (each.equals("2") && s.charAt(i-1)<='6') {
                                total += 1;
                            }
                        }
                    }
                }
                dp[i] += total*dp[i-2];
            }
            dp[i] %= 1000000007;
        }
        //System.out.println(Arrays.toString(dp));
        return (int)dp[dp.length-1];
    }
}
