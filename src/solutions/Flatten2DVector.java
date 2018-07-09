package solutions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Implement an iterator to flatten a 2d vector.
 * 
 * Example:
 * 
 * Input: 2d vector =
 * [
 *   [1,2],
 *   [3],
 *   [4,5,6]
 * ]
 * Output: [1,2,3,4,5,6]
 * Explanation: By calling next repeatedly until hasNext returns false, 
 *              the order of elements returned by next should be: [1,2,3,4,5,6].
 * 
 * Follow up:
 * As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 * 
 * 
 * @author Ellinx
 *
 */
public class Flatten2DVector implements Iterator<Integer>{
    
    private List<Integer> list;
    private int index;

    public Flatten2DVector(List<List<Integer>> vec2d) {
        index = 0;
        list = new ArrayList<>();
        for (List<Integer> each:vec2d) {
            for (int num:each) {
                list.add(num);
            }
        }
    }

    @Override
    public Integer next() {
        index++;
        return list.get(index-1);
    }

    @Override
    public boolean hasNext() {
        return index<list.size();
    }
}
