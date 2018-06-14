package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * An undirected, connected graph of N nodes (labeled 0, 1, 2, ..., N-1) is
 * given as graph.
 * 
 * graph.length = N, and j != i is in the list graph[i] exactly once, if and
 * only if nodes i and j are connected.
 * 
 * Return the length of the shortest path that visits every node. You may start
 * and stop at any node, you may revisit nodes multiple times, and you may reuse
 * edges.
 * 
 * 
 * 
 * Example 1:
 * Input: [[1,2,3],[0],[0],[0]] 
 * Output: 4 
 * Explanation: One possible path is [1,0,2,0,3]
 * 
 * Example 2:
 * Input: [[1],[0,2,4],[1,3,4],[2],[1,2]] 
 * Output: 4 
 * Explanation: One possible path is [0,1,4,2,3]
 * 
 * 
 * 
 * Note:
 * 
 * 1 <= graph.length <= 12 
 * 0 <= graph[i].length < graph.length
 * 
 * @author Ellinx
 *
 */
public class ShortestPathVisitingAllNodes {
    public int shortestPathLength(int[][] graph) {
        //BFS
        int N = graph.length;
        int finalState = (1<<N)-1;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][1<<N];
        int level = 0;
        for (int i=0;i<N;i++) {
            q.offer(new int[]{i, (1<<i)});
            visited[i][1<<i] = true;
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                int[] cur = q.poll();
                if (cur[1]==finalState) {
                    return level;
                }
                for (int next:graph[cur[0]]) {
                    if (!visited[next][cur[1]|(1<<next)]) {
                        visited[next][cur[1]|(1<<next)] = true;
                        q.offer(new int[]{next, cur[1]|(1<<next)});
                    }
                }
            }
            level++;
        }
        return level;
    }
}
