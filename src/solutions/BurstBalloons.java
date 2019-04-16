package solutions;

/**
Given n balloons, indexed from 0 to n-1. 
Each balloon is painted with a number on it represented by array nums. 
You are asked to burst all the balloons. 
If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
Here left and right are adjacent indices of i. 
After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:
1. You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
2. 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:
Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
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
        int n = nums.length;
        int[] newNums = new int[n+2];
        newNums[0] = 1;
        newNums[n+1] = 1;
        for (int i=0;i<n;i++) {
            newNums[i+1] = nums[i];
        }
        int[][] mm = new int[n+2][n+2];
        return dfs(newNums, 0, n+1, mm);
    }
    private int dfs(int[] nums, int left, int right, int[][] mm) {
        if (mm[left][right]>0) {
            return mm[left][right];
        }
        int ret = 0;
        for (int i=left+1;i<right;i++) {
            int temp = nums[left]*nums[i]*nums[right];
            temp += dfs(nums,left,i,mm)+dfs(nums,i,right,mm);
            ret = Math.max(ret, temp);
        }
        mm[left][right] = ret;
        return ret;
    }
}
