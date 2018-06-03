package solutions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 
 * You are asked to cut off trees in a forest for a golf event. The forest is
 * represented as a non-negative 2D map, in this map:
 * 
 * 0 represents the obstacle can't be reached. 1 represents the ground can be
 * walked through. The place with number bigger than 1 represents a tree can be
 * walked through, and this positive number represents the tree's height.
 * 
 * You are asked to cut off all the trees in this forest in the order of tree's
 * height - always cut off the tree with lowest height first. And after cutting,
 * the original place has the tree will become a grass (value 1).
 * 
 * You will start from the point (0, 0) and you should output the minimum steps
 * you need to walk to cut off all the trees. If you can't cut off all the
 * trees, output -1 in that situation.
 * 
 * You are guaranteed that no two trees have the same height and there is at
 * least one tree needs to be cut off.
 * 
 * Example 1:
 * 
 * Input: 
 * [ 
 * 	[1,2,3], 
 * 	[0,0,4], 
 * 	[7,6,5] 
 * ] 
 * Output: 6
 * 
 * Example 2:
 * 
 * Input: 
 * [ 
 * 	[1,2,3], 
 * 	[0,0,0], 
 * 	[7,6,5] 
 * ] 
 * Output: -1
 * 
 * Example 3:
 * 
 * Input: 
 * [ 
 * 	[2,3,4], 
 * 	[0,0,5], 
 * 	[8,7,6] 
 * ] 
 * Output: 6 
 * Explanation: You started from the point (0,0) and you can cut off the 
 * tree in (0,0) directly without walking.
 * 
 * Hint: size of the given matrix will not exceed 50x50.
 * 
 * @author Ellinx
 *
 */
public class CutOffTreesForGolfEvent {
    public int cutOffTree(List<List<Integer>> forest) {
        int ret = 0;
        TreeMap<Integer, int[]> dest = new TreeMap<>();
        for (int i=0;i<forest.size();i++) {
            for (int j=0;j<forest.get(i).size();j++) {
                if (forest.get(i).get(j)>1) {
                    int[] pos = {i,j};
                    dest.put(forest.get(i).get(j), pos);
                }
            }
        }
        int[] start = {0,0};
        for (int key:dest.keySet()) {
            int[] end = dest.get(key);
            int path = BFS(forest, start, end);
            if (path<0)
                return -1;
            forest.get(end[0]).set(end[1],1);
            start = end;
            ret += path;
        }
        return ret;
    }
    
    private int BFS(List<List<Integer>> forest, int[] start, int[] end) {
        int path = 0;
        if (start[0]==end[0] && start[1]==end[1]) {
            return path;
        }
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()]; 
        q.offer(start);
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                int[] cur = q.poll();             
                for (int[] dir:dirs) {
                    int[] next = {cur[0]+dir[0],cur[1]+dir[1]};
                    if (next[0]>=0 && next[0]<forest.size() && next[1]>=0 && next[1]<forest.get(next[0]).size() 
                        && forest.get(next[0]).get(next[1])!=0) {
                        if (next[0]==end[0] && next[1]==end[1]) {
                            return path+1;
                        }
                        if (!visited[next[0]][next[1]]) {
                            q.offer(next);
                            visited[next[0]][next[1]] = true;
                        }
                    }
                }
            }
            path++;
        }
        return -1;
    }
}
