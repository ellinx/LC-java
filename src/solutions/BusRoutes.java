package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * We have a list of bus routes. Each routes[i] is a bus route that the i-th bus
 * repeats forever. For example if routes[0] = [1, 5, 7], this means that the
 * first bus (0-th indexed) travels in the sequence 1->5->7->1->5->7->1->...
 * forever.
 * 
 * We start at bus stop S (initially not on a bus), and we want to go to bus
 * stop T. Travelling by buses only, what is the least number of buses we must
 * take to reach our destination? Return -1 if it is not possible.
 * 
 * Example: Input: routes = [[1, 2, 7], [3, 6, 7]] 
 * S = 1 
 * T = 6 
 * Output: 2
 * Explanation: The best strategy is take the first bus to the bus stop 7, then
 * take the second bus to the bus stop 6.
 * 
 * Note:
 * 
 * 1 <= routes.length <= 500. 
 * 1 <= routes[i].length <= 500. 
 * 0 <= routes[i][j] < 10 ^ 6.
 * 
 *
 */
public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S==T) {
            return 0;
        }
        //BFS
        Map<Integer,Set<Integer>> busInStop = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<routes.length;i++) {
            for (int stop:routes[i]) {
                if (!busInStop.containsKey(stop)) {
                    busInStop.put(stop, new HashSet<Integer>());
                }
                busInStop.get(stop).add(i);
            }
        }
        Set<Integer> visited = new HashSet<>();
        q.offer(S);
        visited.add(S);
        int level = 1;
        while (!q.isEmpty()) {
            int size=q.size();
            // for (int each:visited) {
            //     System.out.print(each+",");
            // }
            // System.out.println();
            for (int i=0;i<size;i++) {
                int curStop = q.poll();
                for (int bus:busInStop.get(curStop)) {
                    for (int nextStop:routes[bus]) {
                        if (nextStop==T) {
                            return level;
                        }
                        if (!visited.contains(nextStop)) {
                            q.offer(nextStop);
                            visited.add(nextStop);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
