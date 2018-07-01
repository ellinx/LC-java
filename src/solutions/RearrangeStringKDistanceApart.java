package solutions;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * Given a non-empty string s and an integer k, rearrange the string such that
 * the same characters are at least distance k from each other.
 * 
 * All input strings are given in lowercase letters. If it is not possible to
 * rearrange the string, return an empty string "".
 * 
 * Example 1:
 * 
 * s = "aabbcc", k = 3
 * 
 * Result: "abcabc"
 * 
 * The same letters are at least distance 3 from each other.
 * 
 * Example 2:
 * 
 * s = "aaabc", k = 3
 * 
 * Answer: ""
 * 
 * It is not possible to rearrange the string.
 * 
 * Example 3:
 * 
 * s = "aaadbbcc", k = 2
 * 
 * Answer: "abacabcd"
 * 
 * Another possible answer is: "abcabcda"
 * 
 * The same letters are at least distance 2 from each other.
 * 
 * @author Ellinx
 *
 */
public class RearrangeStringKDistanceApart {
	/**
	 * Thoughts:
	 * 1. count occurrence of each character in s, simulate the process
	 * 2. put these characters in max heap
	 * 3. each time pick head from the heap to construct new string, then put it into q to rest
	 * 
	 * Time: O(n*log(n)) where n is length of s
	 * Space: O(1)
	 */
    public String rearrangeString(String s, int k) {
        if (k<=1) {
            return s;
        }
        int[] counter = new int[26];
        for (char c:s.toCharArray()) {
            counter[c-'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return b[1]-a[1];
            }
        });
        for (int i=0;i<26;i++) {
            if (counter[i]>0) {
                pq.offer(new int[]{i, counter[i]});
            }
        }
        StringBuilder sb = new StringBuilder();
        Queue<int[]> q = new LinkedList<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            sb.append((char)(cur[0]+'a'));
            cur[1]--;
            q.offer(cur);
            if (q.size()==k) {
                cur = q.poll();
                if (cur[1]>0) {
                    pq.offer(cur);
                }
            }
        }
        for (int[] each:q) {
            if (each[1]>0) {
                return "";
            }
        }
        return sb.toString();
    }
}
