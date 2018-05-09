package ellinx.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author Ellinx
 *
 */
public class RomanToInteger {
	public int romanToInt(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for (int i=0;i<s.length()-1;i++) {
        	if (map.get(s.charAt(i))<map.get(s.charAt(i+1))) {
        		res -= map.get(s.charAt(i));
        	} else {
        		res += map.get(s.charAt(i));
        	}
        }
        res += map.get(s.charAt(s.length()-1));
        return res;
    }
	
	//test
	public static void main(String[] args) {
		RomanToInteger rti = new RomanToInteger();
		int result = rti.romanToInt("LXXX");
		System.out.println(result);
	}
}
