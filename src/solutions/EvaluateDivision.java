package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Equations are given in the format A / B = k, where A and B are variables
 * represented as strings, and k is a real number (floating point number). Given
 * some queries, return the answers. If the answer does not exist, return -1.0.
 * 
 * Example: Given a / b = 2.0, b / c = 3.0. 
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * 
 * The input is: vector<pair<string, string>> equations, vector<double>& values,
 * vector<pair<string, string>> queries , where equations.size() == values.size(), 
 * and the values are positive. This represents the equations.
 * Return vector<double>.
 * 
 * According to the example above:
 * 
 * equations = [ ["a", "b"], ["b", "c"] ], 
 * values = [2.0, 3.0], 
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * 
 * The input is always valid. You may assume that evaluating the queries will
 * result in no division by zero and there is no contradiction.
 * 
 * @author Ellinx
 *
 */
public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String,Double>> map = new HashMap<>();
        for (int i=0;i<equations.length;i++) {
            if (!map.containsKey(equations[i][0])) {
                map.put(equations[i][0], new HashMap<String, Double>());
            }
            if (!map.containsKey(equations[i][1])) {
                map.put(equations[i][1], new HashMap<String, Double>());
            }
            Map<String, Double> map1 = map.get(equations[i][0]);
            map1.put(equations[i][1], values[i]);
            Map<String, Double> map2 = map.get(equations[i][1]);
            map2.put(equations[i][0], 1/values[i]);
        }
        double[] ret = new double[queries.length];
        for (int i=0;i<queries.length;i++) {
            String[] query = queries[i];
            if (!map.containsKey(query[0]) || !map.containsKey(query[1])) {
                ret[i] = -1.0;
                continue;
            }
            Set<String> visited = new HashSet<>();
            visited.add(query[0]);
            ret[i] = dfs(map, query[0], query[1], 1.0, visited);
        }
        return ret;
    }
    
    private double dfs(Map<String, Map<String,Double>> map, String start, String end, double cur, Set<String> visited) {
        if (start.equals(end)) {
            return cur;
        }
        for (String key:map.get(start).keySet()) {
            if (!visited.contains(key)) {
                visited.add(key);
                double ret = dfs(map, key, end, cur*map.get(start).get(key), visited);
                if (ret!=-1) {
                    return ret;
                }
            }
        }
        return -1;
    }
}
