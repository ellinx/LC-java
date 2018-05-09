package ellinx.solutions;

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

public class LRUCache {
	private int capacity;
	private int size;
	private Node head;
	private Node tail;
	private Map<Integer, Node> map;
	
	class Node {
		Node prev;
		Node next;
		int key;
		int value;
		
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			prev = null;
			next = null;
		}
	}
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.size = 0;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
        	return -1;
        }
        
        Node node = map.get(key);
        //remove this node
        node.prev.next = node.next;
        node.next.prev = node.prev;
        //add this node to first
		node.prev = head;
		node.next = head.next;
		head.next = node;
		node.next.prev = node;
        return node.value;
    }
    
    public void put(int key, int value) {
    	Node node = new Node(key, value);
        if (!map.containsKey(key)) {
        	//add this node to first
    		node.prev = head;
    		node.next = head.next;
    		head.next = node;
    		node.next.prev = node;
        	map.put(key, node);
        	this.size++;
        	if (this.size > this.capacity) {
        		Node lastNode = tail.prev;
        		//remove this node
        		lastNode.prev.next = lastNode.next;
        		lastNode.next.prev = lastNode.prev;
        		map.remove(lastNode.key);
        	}
        } else {
        	Node oldNode = map.get(key);
            //remove old node
        	oldNode.prev.next = oldNode.next;
        	oldNode.next.prev = oldNode.prev;
        	//add new node
        	node.prev = head;
    		node.next = head.next;
    		head.next = node;
    		node.next.prev = node;
        	map.put(key, node);
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
