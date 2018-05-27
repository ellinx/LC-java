package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
		Map<String, List<String>> map = new HashMap<>();
        for (String str:strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        List<List<String>> ret = new ArrayList<>();
        for (String k:map.keySet()) {
            ret.add(map.get(k));
        }
        return ret;
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
			System.out.println(list);
		}
	}
}
