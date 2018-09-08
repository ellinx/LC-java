package solutions;

/**
 * 
 * Given a string s, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 * 
 * Example 1:
 * Input: "aacecaaa" 
 * Output: "aaacecaaa" 
 * 
 * Example 2:
 * Input: "abcd" 
 * Output: "dcbabcd"
 * 
 * @author Ellinx
 *
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        String rs = new StringBuilder(s).reverse().toString();
        for (int i=s.length();i>0;i--) {
            if (s.substring(0,i).equals(rs.substring(rs.length()-i))) {
                //System.out.println(i);
                return rs.substring(0,rs.length()-i)+s;
            }
        }
        return "";
    }
}
