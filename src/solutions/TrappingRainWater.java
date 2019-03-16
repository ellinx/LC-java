package solutions;

/**
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped.

Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i=1;i<n;i++) {
            left[i] = Math.max(left[i-1],height[i-1]);
            right[n-1-i] = Math.max(right[n-i],height[n-i]);
        }
        int ret = 0;
        for (int i=1;i<n-1;i++) {
            int water = Math.min(left[i],right[i])-height[i];
            if (water>0) {
                ret += water;
            }
        }
        return ret;
    }
}
