package solutions;

/**
 * 
 * Compare two version numbers version1 and version2. If version1 > version2
 * return 1; if version1 < version2 return -1;otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character. The . character does not represent a decimal point and
 * is used to separate number sequences. For instance, 2.5 is not "two and a
 * half" or "half way to version three", it is the fifth second-level revision
 * of the second first-level revision.
 * 
 * Example 1:
 * 
 * Input: version1 = "0.1", version2 = "1.1" 
 * Output: -1
 * 
 * Example 2:
 * 
 * Input: version1 = "1.0.1", version2 = "1" 
 * Output: 1
 * 
 * Example 3:
 * 
 * Input: version1 = "7.5.2.4", version2 = "7.5.3" 
 * Output: -1
 * 
 * 
 * @author Ellinx
 *
 */
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		String[] v1s = version1.split("\\.");
		String[] v2s = version2.split("\\.");
		// System.out.println(Arrays.toString(v1s));
		// System.out.println(Arrays.toString(v2s));
		int index = 0;
		while (index < Math.min(v1s.length, v2s.length)) {
			int v1 = Integer.parseInt(v1s[index]);
			int v2 = Integer.parseInt(v2s[index]);
			if (v1 > v2) {
				return 1;
			} else if (v1 < v2) {
				return -1;
			}
			index++;
		}
		while (index < v1s.length) {
			int v1 = Integer.parseInt(v1s[index]);
			if (v1 != 0) {
				return 1;
			}
			index++;
		}
		while (index < v2s.length) {
			int v2 = Integer.parseInt(v2s[index]);
			if (v2 != 0) {
				return -1;
			}
			index++;
		}
		return 0;
	}
}
