package ellinx.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 *  1		2[abc]	3[def]
 *  4[ghi]	5[jkl]	6[mno]
 *  7[pqrs]	8[tuv]	9[wxyz]
 *  *		0		#
 * 
 * Input:Digit string "23" 
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]. 
 * 
 * Note: Although the above answer is in lexicographical order, your answer could 
 * be in any order you want.
 * 
 * @author Ellinx
 *
 */
public class LetterCombinationsOfPhoneNumber {
	public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length()==0)
            return res;
        
        String[] map = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        
        for (int i=0;i<digits.length();i++) {
            int index = digits.charAt(i)-'0';
            List<String> next = new ArrayList<>();
            if (res.size()==0) {
                for (int n=0;n<map[index].length();n++) {
                    res.add(""+map[index].charAt(n));
                }
                continue;
            }
            
            for (int m=0;m<res.size();m++) {
                for (int n=0;n<map[index].length();n++) {
                    next.add(res.get(m)+map[index].charAt(n));
                }
            }
            res = next;
        }
        return res;
    }
	
	//test
	public static void main(String[] args) {
		LetterCombinationsOfPhoneNumber lcpn = new LetterCombinationsOfPhoneNumber();
		List<String> result = lcpn.letterCombinations("23");
		System.out.println(result.toString());
	}
	
}
