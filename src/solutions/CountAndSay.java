package solutions;

/**
 * 
 * 
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * 
 * Note: Each term of the sequence of integers will be represented as a string.
 * 
 * Example 1:
 * 
 * Input: 1
 * Output: "1"
 * 
 * Example 2:
 * 
 * Input: 4
 * Output: "1211"
 * 
 * @author Ellinx
 *
 */
public class CountAndSay {
	public String countAndSay(int n) {
        String ret = "1";
        if (n==1)
            return ret;
        for (int i=2;i<=n;i++) {
            ret = helper(ret);
        }
        return ret;
    }
    
    private String helper(String s) {
        int start=0, end = 0;
        StringBuilder sb = new StringBuilder();
        while (end<s.length()) {
            while (end<s.length() && s.charAt(start)==s.charAt(end))
                end++;
            sb.append(""+(end-start));
            sb.append(s.charAt(start));
            start = end;
        }
        return sb.toString();
    }
}
