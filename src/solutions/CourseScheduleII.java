package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, 
return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. 
If it is impossible to finish all courses, return an empty array.

Example 1:
Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
             
Example 2:
Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
             
Note:
1. The input prerequisites is a graph represented by a list of edges, 
	not adjacency matrices. Read more about how a graph is represented.
2. You may assume that there are no duplicate edges in the input prerequisites.
 */

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] ret = new int[numCourses];
        Arrays.fill(ret, -1);
        int idx = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            ret[idx] = cur;
            idx++;
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
        if (idx==numCourses) {
            return ret;
        }
        return new int[0];
    }
}
