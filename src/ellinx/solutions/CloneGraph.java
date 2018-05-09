package ellinx.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Clone an undirected graph. Each node in the graph contains a label 
 * and a list of its neighbors.
 * 
 * @author Ellinx
 *
 */
public class CloneGraph {
	Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null)
            return null;
        
        if (map.containsKey(node.label))
            return map.get(node.label);
        
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        map.put(node.label, res);
        for (UndirectedGraphNode each:node.neighbors) {
            res.neighbors.add(cloneGraph(each));
        }
        return res;
    }
}
