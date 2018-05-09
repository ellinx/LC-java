package ellinx.solutions;

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
    public String reorganizeString(String S) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return b[1]-a[1];
            }
        });
        
        int[] count = new int[26];
        for (int i=0;i<S.length();i++) {
            count[S.charAt(i)-'a']++;
        }
        
        for (int i=0;i<26;i++) {
            if (count[i]>0) {
                int[] arr = {i+'a', count[i]};
                pq.offer(arr);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int[] arr = pq.poll();
        sb.append((char)arr[0]);
        char pre = (char)arr[0];
        arr[1]--;
        if (arr[1]!=0) {
            pq.offer(arr);
        }
        
        while (!pq.isEmpty()) {
            int[] arr1 = pq.poll();
            if (arr1[0]==pre) {
                int[] arr2 = pq.poll();
                if (arr2==null)
                    return "";
                
                sb.append((char)arr2[0]);
                pre = (char)arr2[0];
                arr2[1]--;
                if (arr2[1]!=0) {
                    pq.offer(arr2);
                }
                pq.offer(arr1);
                continue;
            }
            sb.append((char)arr1[0]);
            pre = (char)arr1[0];
            arr1[1]--;
            if (arr1[1]!=0) {
                pq.offer(arr1);
            }
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
