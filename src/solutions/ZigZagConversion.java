package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given 
 * number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 * 
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * @author Ellinx
 *
 */
public class ZigZagConversion {
	public String convert(String s, int numRows) {
        List<List<Character>> list = new ArrayList<>();
        for (int i=0;i<numRows;i++) {
            list.add(new ArrayList<Character>());
        }
        int listIndex = 0;
        int sign = 1;
        for (int i=0;i<s.length();i++) {
            //System.out.println(listIndex);
            list.get(listIndex).add(s.charAt(i));
            if (numRows-1==0)
                continue;
            if (listIndex==numRows-1)
                sign = -1;
            if (listIndex==0)
                sign = 1;
            listIndex += sign;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<numRows;i++) {
            for (char c:list.get(i)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		ZigZagConversion dummy = new ZigZagConversion();
		String s = "PAYPALISHIRING";
		int numRows = 3;
		String result = dummy.convert(s, numRows);
		System.out.println(result);
	}
}
