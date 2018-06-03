package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Given a list of unique words, find all pairs of distinct indices (i, j) in
 * the given list, so that the concatenation of the two words, i.e. words[i] +
 * words[j] is a palindrome.
 * 
 * Example 1: 
 * Given words = ["bat", "tab", "cat"] 
 * Return [[0, 1], [1, 0]] 
 * The palindromes are ["battab", "tabbat"]
 * 
 * Example 2: Given words = ["abcd", "dcba", "lls", "s", "sssll"] 
 * Return [[0, 1], [1, 0], [3, 2], [2, 4]] 
 * The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 * 
 * @author Ellinx
 *
 */
public class PalindromePairs {
	public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for (int i=0;i<words.length;i++) {
            map.put(words[i], i);
        }
        for (int i=0;i<words.length;i++) {
            for (int j=0;j<=words[i].length();j++) {
                String str1 = words[i].substring(0,j);
                String str2 = words[i].substring(j);
                //aba c
                if (isPalindrome(str1)) {
                    String rstr2 = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(rstr2) && map.get(rstr2)!=i) {
                        ret.add(Arrays.asList(map.get(rstr2),i));
                    }
                }
                //abc aba
                if (str2.length()>0 && isPalindrome(str2)) {
                    String rstr1 = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(rstr1) && map.get(rstr1)!=i) {
                        ret.add(Arrays.asList(i, map.get(rstr1)));
                    }
                }
            }
        }
        return ret;
    }
    
    private boolean isPalindrome(String s) {
        int start=0,end=s.length()-1;
        while (start<end) {
            if (s.charAt(start)!=s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
