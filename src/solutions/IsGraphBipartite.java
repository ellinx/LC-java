package solutions;

/**
Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split it's set of nodes into 
two independent subsets A and B such that every edge in the graph has one node in A and another node in B.

The graph is given in the following form: 
graph[i] is a list of indexes j for which the edge between nodes i and j exists.  
Each node is an integer between 0 and graph.length - 1.  

There are no self edges or parallel edges: graph[i] does not contain i, 
and it doesn't contain any element twice.

Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation: 
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.

Example 2:
Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
Output: false
Explanation: 
The graph looks like this:
0----1
| \  |
|  \ |
3----2
We cannot find a way to divide the set of nodes into two independent subsets.
 

Note:
1. graph will have length in range [1, 100].
2. graph[i] will contain integers in range [0, graph.length - 1].
3. graph[i] will not contain i or duplicate values.
4. The graph is undirected: if any element j is in graph[i], then i will be in graph[j].
 */

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        int[] group = new int[N];
        for (int i=0;i<N;i++) {
            if (!dfsMarkOrVerify(graph, group, i, 0)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfsMarkOrVerify(int[][] graph, int[] group, int node, int mark) {
        if (group[node]!=0) {
            if (mark==0) {
                return true;
            }
            return group[node]==mark;
        }
        if (mark==0) {
            group[node] = 1;
        } else {
            group[node] = mark;
        }
        int adjacentMark = -1*group[node];
        for (int next:graph[node]) {
            if (!dfsMarkOrVerify(graph, group, next, adjacentMark)) {
                return false;
            }
        }
        return true;
    }
}
