package ellinx.solutions;

/**
 * Find the length of the longest substring T of a given string (consists of
 * lowercase letters only) such that every character in T appears no less than k
 * times.
 * 
 * Example 1:
 * Input: s = "aaabb", k = 3
 * 
 * Output: 3
 * The longest substring is "aaa", as 'a' is repeated 3 times. 
 * 
 * Example 2:
 * Input: s = "ababbc", k = 2
 * 
 * Output: 5
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is
 * repeated 3 times.
 * 
 * @author Ellinx
 *
 */
public class LongestSubstringWithAtLeastKRepeatingChars {
	public int longestSubstring(String s, int k) {
		int length = s.length();
        if (k<=1) return length;
        
        int maxLength = 0;
        for (int i=0;i<length;i++) {
        	if (maxLength>=length-i) break;
        	int[] arr = new int[26];
        	for (int j=i;j<length;j++) {
        		int index = s.charAt(j)-'a';
        		arr[index]++;
        		boolean valid = true;
        		for (int n=0;n<26;n++) {
        			if (arr[n]>0 && arr[n]<k) {
        				valid = false;
        				break;
        			}
        		}
        		if (valid)
        			maxLength = Math.max(maxLength, j-i+1);
        	}
        }
        return maxLength;
    }
	
	public static void main(String[] args) {
		LongestSubstringWithAtLeastKRepeatingChars tmp = new LongestSubstringWithAtLeastKRepeatingChars();
		String s = "ababb";
		int result = tmp.longestSubstring(s, 2);
		System.out.println(result);
	}
}
