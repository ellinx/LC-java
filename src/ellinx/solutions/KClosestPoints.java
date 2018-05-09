package ellinx.solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given some points and a point origin in two dimensional space, find k points out of the some points which are nearest to origin.
 * Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.
 * 
 * Example
 * Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
 * return [[1,1],[2,5],[4,4]]
 * @author Ellinx
 *
 */

public class KClosestPoints {
	/*
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        Comparator<Point> cmp = new PointCmp();
        PriorityQueue<Point> pq = new PriorityQueue(k, cmp);
        for (Point p : points) {
            Point tmp = new Point(p.x-origin.x, p.y-origin.y);
            pq.add(tmp);
        }
        
        Point[] res = new Point[k];
        for (int i=0;i<k;i++) {
            res[i] = pq.poll();
            res[i].x += origin.x;
            res[i].y += origin.y;
        }
        
        return res;
    }
    
    class PointCmp implements Comparator<Point>{
        public int compare(Point a, Point b) {
            double disA = Math.pow(a.x, 2) + Math.pow(a.y, 2);
            double disB = Math.pow(b.x, 2) + Math.pow(b.y, 2);
            if (disA!=disB) {
                //sort by distance
                return (int)(disA-disB);
            } else {
                if (a.x!=b.x) {
                    //sort by x
                    return a.x-b.x;
                } else {
                    //sort by y
                    return a.y-b.y;
                }
            }
        }
    }
    
    //test
  	public static void main(String[] args) {
  		KClosestPoints KCP = new KClosestPoints();
  		Point[] points = new Point[5];
  		points[0] = new Point(4, 6);
  		points[1] = new Point(4, 7);
  		points[2] = new Point(4, 4);
  		points[3] = new Point(2, 5);
  		points[4] = new Point(1, 1);
  		
  		Point origin = new Point(0, 0);
  		Point[] result = KCP.kClosest(points, origin, 3);
  		for (Point p:result) {
  			System.out.println(p);  			
  		}
  	}
}

