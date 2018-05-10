package ellinx.solutions;

import java.util.Arrays;

/**
 * There are a number of spherical balloons spread in two-dimensional space. For
 * each balloon, provided input is the start and end coordinates of the
 * horizontal diameter. Since it's horizontal, y-coordinates don't matter and
 * hence the x-coordinates of start and end of the diameter suffice. Start is
 * always smaller than end. There will be at most 10^4 balloons.
 * 
 * An arrow can be shot up exactly vertically from different points along the
 * x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart
 * ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An
 * arrow once shot keeps travelling up infinitely. The problem is to find the
 * minimum number of arrows that must be shot to burst all balloons.
 * 
 * Example:
 * 
 * Input: [[10,16], [2,8], [1,6], [7,12]]
 * 
 * Output: 2
 * 
 * Explanation: One way is to shoot one arrow for example at x = 6 (bursting the
 * balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two
 * balloons).
 * 
 * @author Ellinx
 *
 */
public class MinimumNumberOfArrowsToBurstBalloons {
	public int findMinArrowShots(int[][] points) {
        if (points.length<=1) return points.length;
        
        Arrays.sort(points, (int[] a, int[] b)->(a[1]-b[1]));
        
        int res = 0;
        int index = 0;
        while (index < points.length) {
        	int shotPos = points[index][1];
        	res++;
        	index++;
        	while (index<points.length && points[index][0]<=shotPos) {
        		index++;
        	}
        }
        return res;
    }
	
	//test
	public static void main(String[] args) {
		MinimumNumberOfArrowsToBurstBalloons tmp = new MinimumNumberOfArrowsToBurstBalloons();
		int[][] points = {
				{10,16},
				{2,8},
				{1,6},
				{7,12}
		};
		int result = tmp.findMinArrowShots(points);
		System.out.println(result);
	}
}
