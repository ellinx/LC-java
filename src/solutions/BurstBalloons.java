package solutions;

/**
 * 
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * 
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * 
 * Note:
 * 
 *     You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 *     0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 
 * Example:
 * 
 * Input: [3,1,5,8]
 * Output: 167 
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *              coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * 
 * 
 */
public class BurstBalloons {
	/**
	 * Thoughts:
	 * 1. instead of choose which balloon burst first, choose which one is last to burst
	 * 2. Do DFS.
	 * 
	 * Time: O(n^2) where n is length of nums
	 * Space: O(n^2)
	 */
    public int maxCoins(int[] nums) {
        int[] numsWithBoundary = new int[nums.length+2];
        numsWithBoundary[0] = 1;
        for (int i=1;i<numsWithBoundary.length-1;i++) {
            numsWithBoundary[i] = nums[i-1];
        }
        numsWithBoundary[numsWithBoundary.length-1] = 1;
        int[][] mm = new int[numsWithBoundary.length][numsWithBoundary.length];
        return dfs(numsWithBoundary,0,numsWithBoundary.length-1,mm);
    }
    private int dfs(int[] nums, int start, int end, int[][] mm) {
        if (end-start==2) {
            return nums[start]*nums[start+1]*nums[end];
        }
        if (mm[start][end]>0) {
            return mm[start][end];
        }
        int ret = 0;
        for (int i=start+1;i<end;i++) {
            ret = Math.max(ret, nums[start]*nums[i]*nums[end] + dfs(nums,start,i,mm) + dfs(nums,i,end,mm));
        }
        mm[start][end] = ret;
        return ret;
    }
}
