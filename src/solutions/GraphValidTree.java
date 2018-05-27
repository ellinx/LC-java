package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge
 * is a pair of nodes), write a function to check whether these edges make up a
 * valid tree.
 * 
 * Example 1:
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]] 
 * Output: true 
 * 
 * Example 2:
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]] 
 * Output: false
 * 
 * Note: you can assume that no duplicate edges will appear in edges. Since all
 * edges are undirected, [0,1] is the same as [1,0] and thus will not appear
 * together in edges.
 * 
 * @author Ellinx
 *
 */
public class GraphValidTree {
	//union find, each edge should connect one node and do a union
	public boolean validTreeUF(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i=0;i<roots.length;i++) {
            roots[i] = i;
        }
        int count = n;
        for (int[] edge:edges) {
            int root0 = findRoot(roots, edge[0]);
            int root1 = findRoot(roots, edge[1]);
            if (root0==root1)
                return false;
            roots[root0] = root1;
            count--;
            roots[edge[0]] = root1;
            roots[edge[1]] = root1;
        }
        return count==1;
    }
    private int findRoot(int[] roots, int node) {
        while (roots[node]!=node)
            node = roots[node];
        return node;
    }
    
    
    //do a dfs should visit all nodes and use each edge exactly once.
    public boolean validTreeDFS(int n, int[][] edges) {
        if (edges.length!=n-1)
            return false;
        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int[] edge:edges) {
            if (!g.containsKey(edge[0])) {
                g.put(edge[0], new HashSet<Integer>());
            }
            g.get(edge[0]).add(edge[1]);
            if (!g.containsKey(edge[1])) {
                g.put(edge[1], new HashSet<Integer>());
            }
            g.get(edge[1]).add(edge[0]);
        }
        int[] visited = new int[n+1];//last one is total edges visited.
        dfs(g, visited, 0);
        for (int i=0;i<n;i++) {
            if (visited[i]==0)
                return false;
        }
        //System.out.println(visited[n]);
        return visited[n]==edges.length;
    }
    private void dfs(Map<Integer, Set<Integer>> g, int[] visited, int cur) {
        visited[cur] = 1;
        if (!g.containsKey(cur))
            return;
        for (int neighbor:g.get(cur)) {
            if (visited[neighbor]==0) {
                visited[visited.length-1]++;
                dfs(g, visited, neighbor);   
            }
        }
    }
    
    
    //do a dfs should visit all nodes and use each edge exactly once.
    public boolean validTreeBFS(int n, int[][] edges) {
        if (edges.length!=n-1)
            return false;
        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int[] edge:edges) {
            if (!g.containsKey(edge[0])) {
                g.put(edge[0], new HashSet<Integer>());
            }
            g.get(edge[0]).add(edge[1]);
            if (!g.containsKey(edge[1])) {
                g.put(edge[1], new HashSet<Integer>());
            }
            g.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int edgeUsed = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;
        while (q.size()>0) {
            int cur = q.poll();
            if (!g.containsKey(cur))
                continue;
            for (int neighbor:g.get(cur)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                    edgeUsed++;// edge: cur--neighbor
                }
            }
        }
        //check if all nodes are visited
        for (int i=0;i<n;i++) {
            if (!visited[i])
                return false;
        }
        return edgeUsed==edges.length;
    }
}
