package solutions;

/**
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    			Jump 1 step from index 0 to 1, then 3 steps to the last index.
    
Note:
You can assume that you can always reach the last index.
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length==1) {
            return 0;
        }
        int cur = 1;
        int reach = nums[0];
        int step = 1;
        while (cur<=reach) {
            if (reach>=nums.length-1) {
                return step;
            }
            int nxtReach = reach;
            while (cur<=reach) {
                nxtReach = Math.max(nxtReach, cur+nums[cur]);
                cur++;
            }
            reach = nxtReach;
            step++;
        }
        return -1;
    }
}
