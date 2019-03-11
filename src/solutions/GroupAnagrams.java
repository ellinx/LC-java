package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:
1. All inputs will be in lowercase.
2. The order of your output does not matter.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String s:strs) {
            char[] key = s.toCharArray();
            Arrays.sort(key);
            String k = new String(key);
            if (!map.containsKey(k)) {
                map.put(k, new ArrayList<String>());
            }
            map.get(k).add(s);
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
