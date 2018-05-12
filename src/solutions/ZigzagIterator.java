package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two 1d vectors, implement an iterator to return their elements
 * alternately.
 * 
 * Example:
 * Input: v1 = [1,2] v2 = [3,4,5,6]
 * Output: [1,3,2,4,5,6]
 * 
 * Explanation: By calling next repeatedly until hasNext returns false, the
 * order of elements returned by next should be: [1,3,2,4,5,6]. Follow up: What
 * if you are given k 1d vectors? How well can your code be extended to such
 * cases?
 * 
 * Clarification for the follow up question: The "Zigzag" order is not clearly
 * defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to
 * you, replace "Zigzag" with "Cyclic". 
 * 
 * For example:
 * Input: [1,2,3] [4,5,6,7] [8,9]
 * Output: [1,4,8,2,5,9,3,6,7].
 * 
 * @author Ellinx
 *
 */
public class ZigzagIterator {
	private List<Integer> list;
    private int index;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new ArrayList<Integer>();
        this.index = 0;
        int index = 0;
        while (index<v1.size() && index<v2.size()) {
            list.add(v1.get(index));
            list.add(v2.get(index));
            index++;
        }
        while (index<v1.size()) {
            list.add(v1.get(index));
            index++;
        }
        while (index<v2.size()) {
            list.add(v2.get(index));
            index++;
        }
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index<list.size();
    }
    
    /**
     * Your ZigzagIterator object will be instantiated and called as such:
     * ZigzagIterator i = new ZigzagIterator(v1, v2);
     * while (i.hasNext()) v[f()] = i.next();
     */
}
