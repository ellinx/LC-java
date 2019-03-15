package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;

/**
Design a data structure that supports all following operations in average O(1) time.

Note: Duplicate elements are allowed.
1. insert(val): Inserts an item val to the collection.
2. remove(val): Removes an item val from the collection if present.
3. getRandom: Returns a random element from current collection of elements. 
	The probability of each element being returned is linearly related to 
	the number of same value the collection contains.
	
Example:

// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();
 */

public class InsertDeleteGetRandomDuplicatesAllowed {
    
    private List<Integer> list;
    private Map<Integer,TreeSet<Integer>> map;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomDuplicatesAllowed() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean ret = false;
        if (!map.containsKey(val)) {
            map.put(val, new TreeSet<Integer>());
            ret = true;
        }
        int idx = list.size();
        list.add(val);
        map.get(val).add(idx);
        // System.out.println("insert "+val);
        // System.out.println(list);
        return ret;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        TreeSet<Integer> idxes1 = map.get(val);
        // System.out.println(val+":"+idxes1);
        int last1 = idxes1.last();
        TreeSet<Integer> idxes2 = map.get(list.get(list.size()-1));
        // System.out.println(list.get(list.size()-1)+":"+idxes2);
        int last2 = idxes2.last();
        list.set(last1, list.get(last2));
        idxes2.remove(last2);
        idxes2.add(last1);
        list.remove(last2);
        if (idxes1.size()==1) {
            map.remove(val);
        } else {
            idxes1.remove(last1);
        }
        // System.out.println("remove "+val);
        // System.out.println(list);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        Random rand = new Random();
        int idx = rand.nextInt(list.size());
        return list.get(idx);
    }
}
