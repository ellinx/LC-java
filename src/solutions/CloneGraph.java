package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
Given a reference of a node in a connected undirected graph, 
return a deep copy (clone) of the graph. 

Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.


Example:

    1------2
    |      |
    |      |
    4------3

Input:
{"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},
{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}

Explanation:
Node 1's value is 1, and it has two neighbors: Node 2 and 4.
Node 2's value is 2, and it has two neighbors: Node 1 and 3.
Node 3's value is 3, and it has two neighbors: Node 2 and 4.
Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 

Note:
1. The number of nodes will be between 1 and 100.
2. The undirected graph is a simple graph, 
	which means no repeated edges and no self-loops in the graph.
3. Since the graph is undirected, if node p has node q as neighbor, 
	then node q must have node p as neighbor too.
4. You must return the copy of the given node as a reference to the cloned graph.
 */
public class CloneGraph {
	class Node {
	    public int val;
	    public List<Node> neighbors;

	    public Node() {}

	    public Node(int _val,List<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	
    public Node cloneGraph(Node node) {
        return dfs(node, new HashMap<>());
    }
    private Node dfs(Node node, Map<Integer,Node> map) {
        if (node==null) {
            return null;
        }
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node ret = new Node(node.val, new ArrayList<Node>());
        map.put(node.val, ret);
        for (Node neighbors:node.neighbors) {
            ret.neighbors.add(dfs(neighbors, map));
        }
        return ret;
    }
}
