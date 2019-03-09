package solutions;

import java.util.ArrayList;
import java.util.List;

/**
Given a data stream input of non-negative integers a1, a2, ..., an, ..., 
summarize the numbers seen so far as a list of disjoint intervals.

For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., 
then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]

Follow up:
What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 */

public class DataStreamAsDisjointIntervals {
    
    private List<Interval> list;

    /** Initialize your data structure here. */
    public DataStreamAsDisjointIntervals() {
        list = new ArrayList<>();
    }
    
    public void addNum(int val) {
        int idx = insertIdx(val);
        if (idx>=0) {
            return;
        }
        idx = (idx+1)*(-1);
        // check and combine with previous range if possible
        if (idx-1>=0) {
            // within previous range
            if (list.get(idx-1).end>=val) {
                return;
            }
            // extend previous range
            if (list.get(idx-1).end+1==val) {
                list.get(idx-1).end = val;
            } else {
                list.add(idx, new Interval(val,val));
                idx++;
            }   
        } else {
            list.add(idx, new Interval(val,val));
            idx++;
        }
        // check with next range
        if (idx<list.size()) {
            if (list.get(idx-1).end==list.get(idx).start-1) {
                list.get(idx-1).end = list.get(idx).end;
                list.remove(idx);
            }
        }
    }
    private int insertIdx(int val) {
        int l=0, r=list.size()-1;
        while (l<=r) {
            int m = l+(r-l)/2;
            if (list.get(m).start==val) {
                return m;
            }
            if (list.get(m).start>val) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return -l-1;
    }
    
    public List<Interval> getIntervals() {
        return list;
    }
}
/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */