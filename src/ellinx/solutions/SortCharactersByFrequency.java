package ellinx.solutions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 * 
 * Example 1:
 * Input: "tree"
 * 
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once. So 'e'
 * must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * 
 * Example 2:
 * Input: "cccaaa"
 * 
 * Output: "cccaaa"
 * Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid
 * answer. Note that "cacaca" is incorrect, as the same characters must be
 * together. 
 * 
 * Example 3:
 * Input: "Aabb"
 * 
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect. Note
 * that 'A' and 'a' are treated as two different characters.
 * 
 * @author Ellinx
 *
 */
public class SortCharactersByFrequency {
	public String frequencySort(String s) {
		StringBuilder sb = new StringBuilder();
        Map<Character,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
        		(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b)->(b.getValue()-a.getValue())
        		);
        
        for (int i=0;i<s.length();i++) {
        	char a = s.charAt(i);
        	if (map.containsKey(a)) {
        		map.put(a, map.get(a)+1);
        	} else {
        		map.put(a, 1);
        	}
        }
        
        Iterator<Map.Entry<Character, Integer>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
        	Map.Entry<Character, Integer> pair = iter.next();
        	maxHeap.add(pair);
        }
        
        while (!maxHeap.isEmpty()) {
        	Map.Entry<Character, Integer> tmp = maxHeap.poll();
        	for (int i=0;i<tmp.getValue();i++) {
        		sb.append(tmp.getKey());
        	}
        }
        return sb.toString();
    }
	
	//test
	public static void main(String[] args) {
		SortCharactersByFrequency tmp = new SortCharactersByFrequency();
		String result = tmp.frequencySort("tree");
		System.out.println(result);
	}
}
