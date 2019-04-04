package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
Given a directed, acyclic graph of N nodes.  
Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  
graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []] 
Output: [[0,1,3],[0,2,3]] 
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

Note:
1. The number of nodes in the graph will be in the range [2, 15].
2. You can print different paths in any order, but you should keep the order of nodes inside one path.
 */

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer,Set<Integer>> g = new HashMap<>();
        for (int i=0;i<graph.length;i++) {
            if (!g.containsKey(i)) {
                g.put(i, new HashSet<Integer>());
            }
            for (int next:graph[i]) {
                g.get(i).add(next);
            }
        }
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> path = Arrays.asList(0);
        dfs(g, 0, path, graph.length-1, ret);
        return ret;
    }
    private void dfs(Map<Integer,Set<Integer>> g, int cur, List<Integer> path, int target, List<List<Integer>> ret) {
        if (cur==target) {
            ret.add(path);
            return;
        }
        for (int next:g.get(cur)) {
            List<Integer> nextPath = new ArrayList<>(path);
            nextPath.add(next);
            dfs(g, next, nextPath, target, ret);
        }
    }
}
