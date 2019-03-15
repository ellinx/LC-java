package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. 
You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.

Example:
Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

Output: 7 

Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
             the point (1,2) is an ideal empty land to build a house, as the total 
             travel distance of 3+3+1=7 is minimal. So return 7.
             
Note:
1. There will be at least one building. 
2. If it is not possible to build such house according to the above rules, return -1.
 */

public class ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dist = new int[m][n][2];
        List<int[]> buildings = new ArrayList<>();
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j]==1) {
                    buildings.add(new int[]{i,j});
                    dist[i][j][0] = -1;
                } else if (grid[i][j]==2) {
                    dist[i][j][0] = -1;
                }
            }
        }
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int[] src:buildings) {
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{src[0], src[1], 0});
            boolean[][] visited = new boolean[m][n];
            visited[src[0]][src[1]] = true;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                if (dist[cur[0]][cur[1]][0]!=-1) {
                    dist[cur[0]][cur[1]][0] += cur[2];
                    dist[cur[0]][cur[1]][1]++;
                }
                for (int[] each:dirs) {
                    int i = cur[0]+each[0];
                    int j = cur[1]+each[1];
                    if (i>=0 && i<m && j>=0 && j<n && grid[i][j]==0 && !visited[i][j]) {
                        visited[i][j] = true;
                        q.offer(new int[]{i,j,cur[2]+1});
                    }
                }
            }
        }
        int ret = Integer.MAX_VALUE;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (dist[i][j][0]!=-1 && dist[i][j][1]==buildings.size()) {
                    ret = Math.min(ret, dist[i][j][0]);
                }
            }
        }
        if (ret==Integer.MAX_VALUE) {
            return -1;
        }
        return ret;
    }
}
