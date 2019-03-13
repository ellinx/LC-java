package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
Given a binary tree, collect a tree's nodes as if you were doing this: 
Collect and remove all leaves, repeat until the tree is empty.


Example:

Input: [1,2,3,4,5]
  
          1
         / \
        2   3
       / \     
      4   5    

Output: [[4,5,3],[2],[1]]
 

Explanation:

1. Removing the leaves [4,5,3] would result in this tree:

          1
         / 
        2          
 

2. Now removing the leaf [2] would result in this tree:

          1          
 

3. Now removing the leaf [1] would result in the empty tree:

          []   
 */

public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        Map<Integer,List<Integer>> map = new TreeMap<>();
        dfs(root, map);
        List<List<Integer>> ret = new ArrayList<>();
        for (int k:map.keySet()) {
            ret.add(map.get(k));
        }
        return ret;
    }
    private int dfs(TreeNode root, Map<Integer,List<Integer>> map) {
        if (root==null) {
            return -1;
        }
        int left = dfs(root.left, map);
        int right = dfs(root.right, map);
        int dist = Math.max(left, right)+1;
        if (!map.containsKey(dist)) {
            map.put(dist, new ArrayList<Integer>());
        }
        map.get(dist).add(root.val);
        return dist;
    }
}
