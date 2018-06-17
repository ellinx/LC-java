package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * Example 1:
 * 
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * 
 * Example 2:
 * 
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * 
 * 
 * 
 *
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points.length<=2) {
            return points.length;
        }
        int ret = 0;
        Map<List<Integer>,Integer> counter = new HashMap<>();
        for (Point point:points) {
            List<Integer> list = Arrays.asList(point.x, point.y);
            counter.put(list, counter.getOrDefault(list,0)+1);
        }
        //UniPoints: 0-x,1-y,2-number
        List<List<Integer>> UniPoints = new ArrayList<>();
        for (List<Integer> point:counter.keySet()) {
            List<Integer> temp = new ArrayList<Integer>(point);
            temp.add(counter.get(point));
            UniPoints.add(temp);
        }
        
        for (int i=0;i<UniPoints.size();i++) {
            counter = new HashMap<>();
            int same = UniPoints.get(i).get(2);
            ret = Math.max(ret,same);
            int vertical = 0;
            for (int j=i+1;j<UniPoints.size();j++) {
                int deltaY = UniPoints.get(j).get(1)-UniPoints.get(i).get(1);
                int deltaX = UniPoints.get(j).get(0)-UniPoints.get(i).get(0);
                if (deltaX==0) {
                    vertical += UniPoints.get(j).get(2);
                    ret = Math.max(ret,vertical+same);
                    continue;
                }
                int gcd = getGcd(deltaY,deltaX);
                deltaY /= gcd;
                deltaX /= gcd;
                if (deltaX<0) {
                    deltaY *= -1;
                    deltaX *= -1;
                }
                List<Integer> key = Arrays.asList(deltaY,deltaX);
                counter.put(key, counter.getOrDefault(key,0)+UniPoints.get(j).get(2));
                ret = Math.max(ret, counter.get(key)+same);
            }
        }
        return ret;
    }
    
    private int getGcd(int a, int b) {
        while (b!=0) {
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}
