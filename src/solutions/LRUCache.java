package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. 
 * 
 * put(key, value) - Set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently 
 * used item before inserting a new item.
 * 
 * Follow up: Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * LRUCache cache = new LRUCache( 2 // capacity // );
 * 
 * cache.put(1, 1); 
 * cache.put(2, 2); 
 * cache.get(1); // returns 1 
 * cache.put(3, 3); // evicts key 2 
 * cache.get(2); // returns -1 (not found) 
 * cache.put(4, 4); // evicts key 1 
 * cache.get(1); // returns -1 (not found) 
 * cache.get(3); // returns 3 
 * cache.get(4); // returns 4
 * 
 *
 */

class DNode {
    public int key;
    public int val;
    public DNode prev;
    public DNode next;
    
    public DNode(int k, int v) {
        key = k;
        val = v;
        prev = null;
        next = null;
    }
}

public class LRUCache {
    private Map<Integer,DNode> map;
    private DNode head, tail;
    private int size;
    private int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new DNode(0,0);
        tail = new DNode(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
        cap = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DNode node = map.get(key);
        remove(node);
        append(node);
        return node.val;
    }
    private void remove(DNode node) {
        DNode p1 = node.prev, p2 = node.next;
        p1.next = p2;
        p2.prev= p1;
    }
    private void append(DNode node) {
        DNode p1 = tail.prev, p2 = tail;
        p1.next = node;
        node.prev = p1;
        node.next = p2;
        p2.prev = node;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DNode node = map.get(key);
            node.val = value;
            remove(node);
            append(node);
        } else {
            DNode node = new DNode(key,value);
            map.put(key, node);
            append(node);
            size++;
        }
        if (size>cap) {
            DNode node = head.next;
            remove(node);
            map.remove(node.key);
            size--;
        }
    }
    
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    //test
    public static void main(String[] args) {
    	LRUCache cache = new LRUCache(2);
    	cache.put(1, 1); 
    	cache.put(2, 2); 
    	System.out.println(cache.get(1)); // returns 1 
    	cache.put(3, 3); // evicts key 2 
    	System.out.println(cache.get(2)); // returns -1 (not found) 
    	cache.put(4, 4); // evicts key 1 
    	System.out.println(cache.get(1)); // returns -1 (not found) 
    	System.out.println(cache.get(3)); // returns 3 
    	System.out.println(cache.get(4)); // returns 4
	}
    
}
