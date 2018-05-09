package ellinx.solutions;

import java.util.HashMap;
import java.util.Map;


public class WordPattern {
	/**
	 * Given a pattern and a string str, find if str follows the same pattern.
	 * 
	 * Here follow means a full match, such that there is a bijection between a
	 * letter in pattern and a non-empty word in str.
	 * 
	 * Examples: 
	 * pattern = "abba", str = "dog cat cat dog" should return true.
	 * pattern = "abba", str = "dog cat cat fish" should return false. 
	 * pattern = "aaaa", str = "dog cat cat dog" should return false. 
	 * pattern = "abba", str = "dog dog dog dog" should return false. 
	 * 
	 * Notes: You may assume pattern contains only lowercase letters, and str 
	 * contains lowercase letters separated by a single space.
	 * 
	 *
	 */
	public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        Map<Character, String> map = new HashMap<>();
        
        if (strs.length != pattern.length()) {
        	return false;
        }
        
        for (int i=0;i<pattern.length();i++) {
        	char a = pattern.charAt(i);
        	if (map.containsKey(a)) {
        		if (!map.get(a).equals(strs[i])) {
        			return false;
        		}
        	} else {
        		if (map.containsValue(strs[i])) {
        			return false;
        		}
        		map.put(a, strs[i]);
        	}
        }
        return true;
    }
	
	/**
	 * Given a pattern and a string str, find if str follows the same pattern.
	 * Here follow means a full match, such that there is a bijection between 
	 * a letter in pattern and a non-empty substring in str.
	 * 
	 * Examples:
	 * pattern = "abab", str = "redblueredblue" should return true.
	 * pattern = "aaaa", str = "asdasdasdasd" should return true.
	 * pattern = "aabb", str = "xyzabcxzyabc" should return false.
	 */
	public boolean wordPatternMatch(String pattern, String str) {
		if (pattern.length() > str.length()) {
			return false;
		}
		Map<Character, String> map = new HashMap<>();
		return wpMatchHelper(pattern, 0, str, 0, map);
	}
	private boolean wpMatchHelper(String pattern, int patternIndex, String str, int strIndex, Map<Character, String> map) {
		if (patternIndex == pattern.length() && strIndex == str.length()) {
			return true;
		}
		if (patternIndex == pattern.length() || strIndex == str.length()) {
			return false;
		}
		
		char a = pattern.charAt(patternIndex);
		for (int i=strIndex+1;i<=str.length();i++) {
			String tmp = str.substring(strIndex, i);
			if (map.containsKey(a)) {
				if (map.get(a).equals(tmp)) {
					if (wpMatchHelper(pattern, patternIndex+1, str, i, map))
						return true;
				}
			} else {
				if (!map.containsValue(tmp)) {
					map.put(a, tmp);
					if (wpMatchHelper(pattern, patternIndex+1, str, i, map))
						return true;
					map.remove(a);
				}
			}			
		}
		
		return false;
	}
	
	//test
	public static void main(String[] args) {
		WordPattern tmp = new WordPattern();
		boolean result1 = tmp.wordPattern("abba", "cat cat cat cat");
		boolean result2 = tmp.wordPatternMatch("aabb", "catcatcatcat");
		System.out.println(result2);
	}
}
