package solutions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,1,2,1,1].
             
Example 2:
Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,4,6].
 */
public class FlattenNestedListIterator {
}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

class NestedIterator implements Iterator<Integer> {
    private Queue<Integer> q;
    private List<NestedInteger> list;
    private int idx;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        q = new LinkedList<>();
        list = nestedList;
        idx = 0;
    }

    @Override
    public Integer next() {
        return q.poll();
    }

    @Override
    public boolean hasNext() {
        while (q.isEmpty() && idx<list.size()) {
            NestedInteger cur = list.get(idx);
            idx++;
            flatten(q, cur);
        }
        return !q.isEmpty();
    }
    private void flatten(Queue<Integer> q, NestedInteger cur) {
        if (cur.isInteger()) {
            q.offer(cur.getInteger());
            return;
        }
        for (NestedInteger each:cur.getList()) {
            flatten(q, each);
        }
    }
    
    /**
     * Your NestedIterator object will be instantiated and called as such:
     * NestedIterator i = new NestedIterator(nestedList);
     * while (i.hasNext()) v[f()] = i.next();
     */
}