package solutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
We are given a list schedule of employees, which represents the working time for each employee.

Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.

Return the list of finite intervals representing common, 
positive-length free time for all employees, also in sorted order.

Example 1:
Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
Output: [[3,4]]
Explanation:
There are a total of three employees, and all common
free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any intervals that contain inf as they aren't finite.

Example 2:
Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
Output: [[5,6],[7,9]]
(Even though we are representing Intervals in the form [x, y], 
the objects inside are Intervals, not lists or arrays. 
For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined.)

Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.

Note:
1. schedule and schedule[i] are lists with lengths in range [1, 50].
2. 0 <= schedule[i].start < schedule[i].end <= 10^8.
 */

public class EmployeeFreeTime {
    class Element {
        public Interval interval;
        public int idx1;
        public int idx2;
        public Element(Interval inter, int i1, int i2) {
            interval = inter;
            idx1 = i1;
            idx2 = i2;
        }
    }
    
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>(){
            public int compare(Element a, Element b) {
                return a.interval.start-b.interval.start;
            }
        });
        for (int i=0;i<schedule.size();i++) {
            pq.offer(new Element(schedule.get(i).get(0),i,0));
        }
        List<Interval> ret = new ArrayList<>();
        int end = -1;
        while (!pq.isEmpty()) {
            Element cur = pq.poll();
            if (end<0) {
                end = cur.interval.end;
            } else {
                if (end<cur.interval.start) {
                    ret.add(new Interval(end,cur.interval.start));
                }
                end = Math.max(end, cur.interval.end);
            }
            if (cur.idx2+1<schedule.get(cur.idx1).size()) {
                int i1 = cur.idx1;
                int i2 = cur.idx2+1;
                pq.offer(new Element(schedule.get(i1).get(i2),i1,i2));
            }
        }
        return ret;
    }
}
