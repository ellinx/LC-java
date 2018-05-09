package ellinx.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * 
 * Return:
 * 
 * [ 
 * 		["ate", "eat","tea"], 
 * 		["nat","tan"], 
 * 		["bat"] 
 * ] 
 * Note: All inputs will be in lower-case.
 * 
 * @author Ellinx
 *
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String keyStr = new String(arr);
            if (map.containsKey(keyStr)) {
                List<String> tmp = map.get(keyStr);
                tmp.add(str);
                map.put(keyStr,tmp);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(str);
                map.put(keyStr,tmp);
            }
        }
        
        Iterator<List<String>> iter = map.values().iterator();
        while (iter.hasNext()) {
            List<String> tmp = iter.next();
            res.add(tmp);
        }
        return res;
    }
	
	//test
	public static void main(String[] args) {
		GroupAnagrams tmp = new GroupAnagrams();
		String[] strs = {
				"eat", 
				"tea", 
				"tan", 
				"ate", 
				"nat", 
				"bat"
		};
		List<List<String>> result = tmp.groupAnagrams(strs);
		for (List<String> list:result) {
			System.out.print("[");
			for (String str:list) {
				System.out.println(str+",");
			}
			System.out.println("]");
		}
	}
}
