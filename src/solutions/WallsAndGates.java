package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * You are given a m x n 2D grid initialized with these three possible values.
 * 
 * 1. -1 - A wall or an obstacle.
 * 2. 0 - A gate.
 * 3. INF - Infinity means an empty room. 
 * 
 * We use the value 231 - 1 = 2147483647 to represent INF 
 * as you may assume that the distance to a gate is less than 2147483647.
 * 
 * Fill each empty room with the distance to its nearest gate. 
 * If it is impossible to reach a gate, it should be filled with INF.
 * 
 * Example: 
 * 
 * Given the 2D grid:
 * 
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 * 
 * After running your function, the 2D grid should be:
 * 
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 * 
 * 
 *
 */
public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        int INF = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        for (int i=0;i<rooms.length;i++) {
            for (int j=0;j<rooms[0].length;j++) {
                if (rooms[i][j]==0) {
                    q.offer(new int[]{i,j});
                }
            }
        }
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int[] dir:dirs) {
                    int i = cur[0]+dir[0];
                    int j = cur[1]+dir[1];
                    if (i>=0 && i<rooms.length && j>=0 && j<rooms[0].length && rooms[i][j]==INF) {
                        rooms[i][j] = dist+1;
                        q.offer(new int[]{i,j});
                    }
                }
            }
            dist++;
        }
    }
}
