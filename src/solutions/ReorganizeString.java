package solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given a string S, check if the letters can be rearranged so that two
 * characters that are adjacent to each other are not the same.
 * 
 * If possible, output any possible result. If not possible, return the empty
 * string.
 * 
 * Example 1:
 * 
 * Input: S = "aab" 
 * Output: "aba" 
 * 
 * Example 2:
 * 
 * Input: S = "aaab" 
 * Output: "" 
 * 
 * Note:
 * S will consist of lowercase letters and have length in range [1, 500].
 * 
 * @author Ellinx
 *
 */
public class ReorganizeString {
	/**
	 * Thoughts:
	 * 1. count occurrence of each character in S
	 * 2. put these characters in max heap
	 * 3. each time pick head from the heap to construct new string, then put it aside to rest one round(a character apart)
	 * 
	 * Time: O(n*log(n)) where n is length of S
	 * Space: O(n)
	 */
    public String reorganizeString(String S) {
        int[] counter = new int[26];
        for (char c:S.toCharArray()) {
            counter[c-'a']++;
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return b[1]-a[1];
            }
        });
        for (int i=0;i<counter.length;i++) {
            if (counter[i]>0) {
                maxHeap.offer(new int[]{i, counter[i]});
            }
        }
        int[] rest = {0,0};
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] cur = maxHeap.poll();
            sb.append((char)('a'+cur[0]));
            cur[1]--;
            if (rest[1]>0) {
                maxHeap.offer(rest);
            }
            rest = cur;
        }
        if (rest[1]>0) {
            return "";
        }
        return sb.toString();
    }
    
    //test
    public static void main(String[] args) {
    	ReorganizeString rs = new ReorganizeString();
    	String result = rs.reorganizeString("aab");
    	System.out.println(result);
	}
}
