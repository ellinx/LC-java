package solutions;

import java.util.Arrays;

/**
A chess knight can move as indicated in the chess diagram below:

 1  2  3
 4  5  6
 7  8  9
    0

This time, we place our chess knight on any numbered key of a phone pad (indicated above), 
and the knight makes N-1 hops.  Each hop must be from one key to another numbered key.

Each time it lands on a key (including the initial placement of the knight), 
it presses the number of that key, pressing N digits total.

How many distinct numbers can you dial in this manner?

Since the answer may be large, output the answer modulo 10^9 + 7.

 
Example 1:
Input: 1
Output: 10

Example 2:
Input: 2
Output: 20

Example 3:
Input: 3
Output: 46
 

Note:
1 <= N <= 5000
 */

public class KnightDialer {
    public int knightDialer(int N) {
        int mod = (int)Math.pow(10,9)+7;
        int[] dp = new int[10];
        Arrays.fill(dp, 1);
        int[][] jumpFrom = {{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
        for (int i=0;i<N-1;i++) {
            int[] nextDp = new int[10];
            for (int j=0;j<10;j++) {
                for (int num:jumpFrom[j]) {
                    nextDp[j] += dp[num];
                    nextDp[j] %= mod;
                }
            }
            dp = nextDp;
            // System.out.println(Arrays.toString(dp));
        }
        int ret = 0;
        for (int num:dp) {
            ret += num;
            ret %= mod;
        }
        return ret;
    }
}
