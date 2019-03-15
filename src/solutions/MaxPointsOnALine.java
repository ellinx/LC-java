package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:
Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4

Example 2:
Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        int ret = 0;
        for (int i=0;i<points.length;i++) {
            int same = 1;
            int vertical = 0;
            Map<String,Integer> counter = new HashMap<>();
            for (int j=i+1;j<points.length;j++) {
                if (points[i].x==points[j].x && points[i].y==points[j].y) {
                    same++;
                    continue;
                }
                if (points[i].x==points[j].x) {
                    vertical++;
                    continue;
                }
                int gcd = getGCD(points[j].y-points[i].y, points[j].x-points[i].x);
                String key = (points[j].y-points[i].y)/gcd+","+(points[j].x-points[i].x)/gcd;
                counter.put(key, counter.getOrDefault(key,0)+1);
            }
            ret = Math.max(ret, same+vertical);
            for (String k:counter.keySet()) {
                ret = Math.max(ret, same+counter.get(k));
            }
        }
        return ret;
    }
    private int getGCD(int a, int b) {
        while (b!=0) {
            int c = a%b;
            a = b;
            b = c;
        }
        return a;
    }
}
