package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, 
is it possible for you to finish all courses?

Example 1:
Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
             
Example 2:
Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
             
Note:
1. The input prerequisites is a graph represented by a list of edges, 
	not adjacency matrices. Read more about how a graph is represented.
2. You may assume that there are no duplicate edges in the input prerequisites.
 */

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] each:prerequisites) {
            if (!map.containsKey(each[1])) {
                map.put(each[1], new HashSet<Integer>());
            }
            if (map.get(each[1]).contains(each[0])) {
                continue;
            }
            map.get(each[1]).add(each[0]);
            indegree[each[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<numCourses;i++) {
            if (indegree[i]==0) {
                q.offer(i);
            }
        }
        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            order.add(cur);
            if (!map.containsKey(cur)) {
                continue;
            }
            for (int next:map.get(cur)) {
                indegree[next]--;
                if (indegree[next]==0) {
                    q.add(next);
                }
            }
        }
        return order.size()==numCourses;
    }
}
