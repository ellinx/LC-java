package solutions;

/**
 * 
 * Given a char array representing tasks CPU need to do. It contains capital
 * letters A to Z where different letters represent different tasks.Tasks could
 * be done without original order. Each task could be done in one interval. For
 * each interval, CPU could finish one task or just be idle.
 * 
 * However, there is a non-negative cooling interval n that means between two
 * same tasks, there must be at least n intervals that CPU are doing different
 * tasks or just be idle.
 * 
 * You need to return the least number of intervals the CPU will take to finish
 * all the given tasks.
 * 
 * Example 1:
 * 
 * Input: tasks = ["A","A","A","B","B","B"], n = 2 
 * Output: 8 
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * 
 * Note:
 * 
 * The number of tasks is in the range [1, 10000]. The integer n is in the range
 * [0, 100].
 * 
 * @author Ellinx
 *
 */
public class TaskScheduler {
	/**
	 * Thoughts:
	 * 1. count max frequency task and how many tasks has max frequency.
	 * 2. two cases: 
	 * 		if n< number of tasks which has max frequency
	 * 		eg. tasks=[a,a,b,b,c,c], n = 1
	 * 		abcabc
	 * 		total length will be length of tasks
	 * 		otherwise
	 * 		eg. tasks=[a,a,b,b,c,c], n = 3
	 * 		abc_abc
	 * 		total length will be (n+1)*(max-1)+num
	 * 
	 * Time:O(n) where n is length of tasks
	 * Space: O(1)
	 */
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        for (char c:tasks) {
            counter[c-'A']++;
            max = Math.max(max, counter[c-'A']);
        }
        int num = 0;
        for (int i=0;i<26;i++) {
            if (counter[i]==max) {
                num++;
            }
        }
        int ret = (max-1)*(n+1)+num;
        return Math.max(ret, tasks.length);
    }
}
