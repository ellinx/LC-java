package solutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
A city's skyline is the outer contour of the silhouette formed by all the buildings in that city 
when viewed from a distance. Now suppose you are given the locations and height of all the buildings 
as shown on a cityscape photo (Figure A), write a program to output the skyline 
formed by these buildings collectively (Figure B).

Buildings  Skyline Contour
The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], 
where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, 
and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. 
You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: 
[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of 
[ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. 
A key point is the left endpoint of a horizontal line segment. 
Note that the last key point, where the rightmost building ends, 
is merely used to mark the termination of the skyline, and always has zero height. 
Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:
[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:
1. The number of buildings in any input list is guaranteed to be in the range [0, 10000].
2. The input list is already sorted in ascending order by the left x position Li.
3. The output list must be sorted by the x position.
4. There must be no consecutive horizontal lines of equal height in the output skyline. 
	For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; 
	the three lines of height 5 should be merged into one in the final output as such: 
	[...[2 3], [4 5], [12 7], ...]
 */

public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        //[x,start/end,height,idx]
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[0]==b[0]) {
                    if (a[1]==b[1]) {
                        return (a[1]==0)?(b[2]-a[2]):(a[2]-b[2]);
                    }
                    return a[1]-b[1];
                }
                return a[0]-b[0];
            }
        });
        for (int i=0;i<buildings.length;i++) {
            pq.offer(new int[]{buildings[i][0],0,buildings[i][2],i});
            pq.offer(new int[]{buildings[i][1],1,buildings[i][2],i});
        }
        PriorityQueue<int[]> skyline = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return b[0]-a[0];
            }
        });
        List<int[]> ret = new ArrayList<>();
        int curSky = 0;
        int x = 0;
        Set<Integer> removed = new HashSet<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            x = cur[0];
            if (cur[1]==0) {
                //building start
                skyline.offer(new int[]{cur[2],cur[3]});
            } else {
                //building end
                removed.add(cur[3]);
            }
            boolean flag = false;
            while (!skyline.isEmpty()) {
                if (removed.contains(skyline.peek()[1])) {
                    skyline.poll();
                    continue;
                }
                if (skyline.peek()[0]==curSky) {
                    flag = true;
                    break;
                }
                curSky = skyline.peek()[0];
                ret.add(new int[]{x,curSky});
                flag = true;
                break;
            }
            if (!flag) {
                ret.add(new int[]{x,0});
            }
        }
        return ret;
    }
}
