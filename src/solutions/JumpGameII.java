package solutions;

/**
 * 
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * Input: [2,3,1,1,4] 
 * Output: 2 
 * Explanation: The minimum number of jumps to reach the last index is 2. 
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Note:
 * 
 * You can assume that you can always reach the last index.
 * 
 * @author Ellinx
 *
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int index = 0;
        int curMax = 0;
        int step = 0;
        if (curMax>=nums.length-1) {
            return step;
        }
        while (index<=curMax) {
            int nextMax = curMax;
            while (index<=curMax) {
                nextMax = Math.max(nextMax, index+nums[index]);
                index++;
            }
            step++;
            curMax = nextMax;
            //System.out.println(index+","+curMax+","+step);
            if (curMax>=nums.length-1) {
                break;
            }
        }
        return step;
    }
}
