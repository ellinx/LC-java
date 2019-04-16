package solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
There is a ball in a maze with empty spaces and walls. 
The ball can go through empty spaces by rolling up, down, left or right, 
but it won't stop rolling until hitting a wall. 

When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, 
find the shortest distance for the ball to stop at the destination. 

The distance is defined by the number of empty spaces traveled by the ball 
from the start position (excluded) to the destination (included). 
If the ball cannot stop at the destination, return -1.

The maze is represented by a binary 2D array. 
1 means the wall and 0 means the empty space. 
You may assume that the borders of the maze are all walls. 
The start and destination coordinates are represented by row and column indexes.

 

Example 1:

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: 12

Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
             The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.

Example 2:

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: -1

Explanation: There is no way for the ball to stop at the destination.

 

Note:
1. There is only one ball and one destination in the maze.
2. Both the ball and the destination exist on an empty space, 
	and they will not be at the same position initially.
3. The given maze does not contain border (like the red rectangle in the example pictures), 
	but you could assume the border of the maze are all walls.
4. The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
 */

public class TheMazeII {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        if (m==0) {
            return -1;
        }
        int n = maze[0].length;
        int[][] dist = new int[m][n];
        for (int[] each:dist) {
            Arrays.fill(each,-1);
        }
        dist[start[0]][start[1]] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        pq.offer(new int[]{0, start[0], start[1]});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            //up
            int i = cur[1];
            int j = cur[2];
            while (i>=0 && maze[i][j]==0) {
                i--;
            }
            i++;
            int curDist = cur[0]+cur[1]-i;
            if (dist[i][j]==-1 || curDist<dist[i][j]) {
                dist[i][j] = curDist;
                pq.offer(new int[]{curDist, i, j});
            }
            //down
            i = cur[1];
            j = cur[2];
            while (i<m && maze[i][j]==0) {
                i++;
            }
            i--;
            curDist = cur[0]+i-cur[1];
            if (dist[i][j]==-1 || curDist<dist[i][j]) {
                dist[i][j] = curDist;
                pq.offer(new int[]{curDist, i, j});
            }
            //left
            i = cur[1];
            j = cur[2];
            while (j>=0 && maze[i][j]==0) {
                j--;
            }
            j++;
            curDist = cur[0]+cur[2]-j;
            if (dist[i][j]==-1 || curDist<dist[i][j]) {
                dist[i][j] = curDist;
                pq.offer(new int[]{curDist, i, j});
            }
            //right
            i = cur[1];
            j = cur[2];
            while (j<n && maze[i][j]==0) {
                j++;
            }
            j--;
            curDist = cur[0]+j-cur[2];
            if (dist[i][j]==-1 || curDist<dist[i][j]) {
                dist[i][j] = curDist;
                pq.offer(new int[]{curDist, i, j});
            }
        }
        return dist[destination[0]][destination[1]];
    }
}
