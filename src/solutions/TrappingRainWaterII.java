package solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.
 * 
 * Note:
 * Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.
 * 
 * Example:
 * 
 * Given the following 3x6 height map:
 * [
 *   [1,4,3,1,3,2],
 *   [3,2,1,3,2,4],
 *   [2,3,3,2,3,1]
 * ]
 * 
 * Return 4.
 * 
 *
 */
public class TrappingRainWaterII {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        if (m<3) {
            return 0;
        }
        int n = heightMap[0].length;
        if (n<3) {
            return 0;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[2]-b[2];
            }
        });
        boolean[][] visited = new boolean[m][n];
        //add board to pq
        for (int i=0;i<n;i++) {
            visited[0][i] = true;
            pq.offer(new int[]{0,i,heightMap[0][i]});
            visited[m-1][i] = true;
            pq.offer(new int[]{m-1,i,heightMap[m-1][i]});
        }
        for (int i=1;i<m-1;i++) {
            visited[i][0] = true;
            pq.offer(new int[]{i,0,heightMap[i][0]});
            visited[i][n-1] = true;
            pq.offer(new int[]{i,n-1,heightMap[i][n-1]});
        }
        int ret = 0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int[] dir:dirs) {
                int x = cur[0]+dir[0];
                int y = cur[1]+dir[1];
                if (x>=0 && x<m && y>=0 && y<n && !visited[x][y]) {
                    visited[x][y] = true;
                    ret += Math.max(0, cur[2]-heightMap[x][y]);
                    pq.offer(new int[]{x,y,Math.max(cur[2], heightMap[x][y])});
                }
            }
        }
        return ret;
    }
}
