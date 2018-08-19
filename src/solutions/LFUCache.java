package solutions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. put(key, value) - Set or insert the
 * value if the key is not already present. When the cache reaches its capacity,
 * it should invalidate the least frequently used item before inserting a new
 * item. For the purpose of this problem, when there is a tie (i.e., two or more
 * keys that have the same frequency), the least recently used key would be
 * evicted.
 * 
 * Follow up: Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * LFUCache cache = new LFUCache( 2 );
 * 
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1); // returns 1 
 * cache.put(3,3); // evicts key 2 
 * cache.get(2); // returns -1 (not found) 
 * cache.get(3); // returns 3. 
 * cache.put(4,4); // evicts key 1. 
 * cache.get(1); // returns -1 (not found)
 * cache.get(3); // returns 3 
 * cache.get(4); // returns 4
 * 
 * @author Ellinx
 *
 */
public class LFUCache {
    private int cap=0;
    private TreeSet<int[]> set;
    private Map<Integer, int[]> map;
    private int ops = 0;

    public LFUCache(int capacity) {
        cap = capacity;
        set = new TreeSet<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[2]==b[2]) {
                    return b[3]-a[3];
                }
                return b[2]-a[2];
            }
        });
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            int[] entry = map.get(key);
            set.remove(entry);
            entry[2]++;
            entry[3] = ops;
            ops++;
            set.add(entry);
            return entry[1];
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cap==0) {
            return;
        }
        if (map.containsKey(key)) {
            int[] entry = map.get(key);
            set.remove(entry);
            entry[1] = value;
            entry[2]++;
            entry[3] = ops;
            ops++;
            set.add(entry);
        } else {
            if (set.size()==cap) {
                int[] last = set.pollLast();
                map.remove(last[0]);
            }
            int[] entry = new int[]{key, value, 1, ops};
            ops++;
            map.put(key, entry);
            set.add(entry);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */