package solutions;

/**
 * 
 * On a horizontal number line, we have gas stations at positions stations[0],
 * stations[1], ..., stations[N-1], where N = stations.length.
 * 
 * Now, we add K more gas stations so that D, the maximum distance between
 * adjacent gas stations, is minimized.
 * 
 * Return the smallest possible value of D.
 * 
 * Example:
 * 
 * Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9 
 * Output: 0.500000
 * 
 * Note:
 * 
 * stations.length will be an integer in range [10, 2000]. stations[i] will be
 * an integer in range [0, 10^8]. K will be an integer in range [1, 10^6].
 * Answers within 10^-6 of the true value will be accepted as correct.
 * 
 * @author Ellinx
 *
 */
public class MinimizeMaxDistanceToGasStation {
	public double minmaxGasDist(int[] stations, int K) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int station:stations) {
            min = Math.min(min, station);
            max = Math.max(max, station);
        }
        double left = 0;
        double right = max-min;
        //find possible gap
        while (left+Math.pow(10,-6)<right) {
            double mid = left+(right-left)/2;
            int count = 0;
            for (int i=1;i<stations.length;i++) {
                count += Math.ceil((stations[i]-stations[i-1])/mid)-1;
            }
            if (count>K) {
                left = mid+Math.pow(10,-6);
            } else {
                right = mid;
            }
        }
        return left;
    }
}
