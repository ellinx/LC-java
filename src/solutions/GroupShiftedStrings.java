package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Given a string, we can "shift" each of its letter to its successive letter,
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * 
 * "abc" -> "bcd" -> ... -> "xyz"
 * 
 * Given a list of strings which contains only lowercase alphabets, group all
 * strings that belong to the same shifting sequence.
 * 
 * Example:
 * 
 * Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
 * Output: [ ["abc","bcd","xyz"], ["az","ba"], ["acef"], ["a","z"] ]
 * 
 * 
 * @author Ellinx
 *
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ret = new ArrayList<>();
        Map<List<Integer>, List<String>> map = new HashMap<>();
        for (String s:strings) {
            List<Integer> key = new ArrayList<>();
            char c = 'a';
            for (int i=0;i<s.length();i++) {
                if (i==0) {
                    c = s.charAt(i);
                    key.add(0);
                } else {
                    int val = s.charAt(i)-c;
                    if (val<0) {
                        val += 26;
                    }
                    key.add(val);
                }
            }
            if (!map.containsKey(key)) {
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        for (List<String> each:map.values()) {
            ret.add(each);
        }
        return ret;
    }
}
