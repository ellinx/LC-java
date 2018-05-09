package ellinx.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * 
 * Example
 * Given n = 2, prerequisites = [[1,0]]
 * Return true
 * 
 * Given n = 2, prerequisites = [[1,0],[0,1]]
 * Return false
 * @author Ellinx
 *
 */

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Write your code here
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>(numCourses);
        List<Integer> indegree = new ArrayList<Integer>(numCourses);
        for (int i=0;i<numCourses;i++) {
            graph.add(new HashSet<Integer>());
            indegree.add(0);
        }
        
        for (int i=0;i<prerequisites.length;i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            
            Set<Integer> tmp = graph.get(from);
            if (!tmp.contains(to)) {
                tmp.add(to);
                indegree.set(to,indegree.get(to)+1);
                graph.set(from, tmp);
            }
            
        }
        
        Set<Integer> toVisit = new HashSet<Integer>();
        for (int i=0;i<numCourses;i++) {
            if (indegree.get(i)==0) {
                toVisit.add(i);
            }
        }
        
        while (toVisit.size()!=0) {
            Iterator<Integer> toIter = toVisit.iterator();
            int node = toIter.next();
            toIter.remove();
            Iterator<Integer> iter=graph.get(node).iterator();
            while (iter.hasNext()) {
                int m = iter.next();
                iter.remove();
                indegree.set(m, indegree.get(m)-1);
                if (indegree.get(m)==0) {
                    toVisit.add(m);
                }
            }
        }
        for (int i=0;i<numCourses;i++) {
            if (graph.get(i).size()!=0) return false;
        }
        return true;
    }
}
