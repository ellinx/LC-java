package solutions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * Given a nested list of integers, implement an iterator to flatten it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be
 * integers or other lists.
 * 
 * Example 1:
 * 
 * Input: [[1,1],2,[1,1]] 
 * Output: [1,1,2,1,1] 
 * Explanation: By calling next repeatedly until hasNext returns false, 
 * the order of elements returned by next should be: [1,1,2,1,1].
 * 
 * Example 2:
 * 
 * Input: [1,[4,[6]]] 
 * Output: [1,4,6] 
 * Explanation: By calling next repeatedly until hasNext returns false, 
 * the order of elements returned by next should be: [1,4,6].
 * 
 * 
 * @author Ellinx
 *
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
    List<Integer> list;
    int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        index = 0;
        for (NestedInteger each:nestedList) {
            dfs(each, list);
        }
    }
    
    private void dfs(NestedInteger n, List<Integer> list) {
        if (n.isInteger()) {
            list.add(n.getInteger());
            return;
        }
        for (NestedInteger each:n.getList()) {
            dfs(each, list);
        }
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index<list.size();
    }
}