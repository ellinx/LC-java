package solutions;

/**
 * 
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In
 * this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 * 
 * Example:
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
 * 
 * @author Ellinx
 *
 */
public class TrappingRainWater {
	public int trap(int[] height) {
		int[] left = new int[height.length];
		int[] right = new int[height.length];
		for (int i = 1; i < height.length; i++) {
			left[i] = Math.max(left[i - 1], height[i - 1]);
			right[height.length - 1 - i] = Math.max(right[height.length - i], height[height.length - i]);
		}
		int ret = 0;
		for (int i = 0; i < height.length; i++) {
			int temp = Math.min(left[i], right[i]);
			if (temp > height[i]) {
				ret += temp - height[i];
			}
		}
		return ret;
	}
}
