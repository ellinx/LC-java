package solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
S and T are strings composed of lowercase letters. 
In S, no letter occurs more than once.

S was sorted in some custom order previously. 
We want to permute the characters of T so that they match the order that S was sorted. 
More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

Example :
Input: 
S = "cba"
T = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in S, it can be at any position in T. 
"dcba", "cdba", "cbda" are also valid outputs.
 

Note:
1. S has length at most 26, and no character is repeated in S.
2. T has length at most 200.
3. S and T consist of lowercase letters only.
 */

public class CustomSortString {
	//count characters in T, construct new string according to S
    public String customSortString(String S, String T) {
        Map<Character,Integer> counter = new HashMap<>();
        for (int i=0;i<T.length();i++) {
            counter.put(T.charAt(i), counter.getOrDefault(T.charAt(i),0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for (char c:S.toCharArray()) {
            if (counter.containsKey(c)) {
                for (int i=0;i<counter.get(c);i++) {
                    sb.append(c);
                }
                counter.remove(c);
            }
        }
        for (char c:counter.keySet()) {
            for (int i=0;i<counter.get(c);i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
	
    
    //based on S, give each character in S a rank
    //sort T based on the rank
    public String customSortString2(String S, String T) {
        Map<String,Integer> rank = new HashMap<>();
        for (int i=0;i<S.length();i++) {
            rank.put(S.substring(i,i+1), i);
        }
        String[] arr = T.split("");
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String a, String b) {
                if (!rank.containsKey(a)) {
                    rank.put(a,-1);
                }
                if (!rank.containsKey(b)) {
                    rank.put(b,-1);
                }
                return rank.get(a)-rank.get(b);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s:arr) {
            sb.append(s);
        }
        return sb.toString();
    }
}
