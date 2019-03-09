package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
Given a binary tree, return the vertical order traversal of its nodes' values. 
(ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples 1:
Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7 

Output:

[
  [9],
  [3,15],
  [20],
  [7]
]

Examples 2:
Input: [3,9,8,4,0,1,7]

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7 

Output:

[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]

Examples 3:
Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2

Output:

[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
 */

public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer,List<Integer>> map = new TreeMap<>();
        if (root==null) {
            return new ArrayList<List<Integer>>();
        }
        // bfs tree
        List<TreeNode> cur = Arrays.asList(root);
        List<Integer> cols = Arrays.asList(0);
        while (!cur.isEmpty()) {
            List<TreeNode> next = new ArrayList<>();
            List<Integer> nextCols = new ArrayList<>();
            for (int i=0;i<cur.size();i++) {
                //store in map
                if (!map.containsKey(cols.get(i))) {
                    map.put(cols.get(i), new ArrayList<Integer>());
                }
                map.get(cols.get(i)).add(cur.get(i).val);
                //prepair for next level
                if (cur.get(i).left!=null) {
                    nextCols.add(cols.get(i)-1);
                    next.add(cur.get(i).left);
                }
                if (cur.get(i).right!=null) {
                    nextCols.add(cols.get(i)+1);
                    next.add(cur.get(i).right);
                }
            }
            cur = next;
            cols = nextCols;
        }
        //prepare for return data
        List<List<Integer>> ret = new ArrayList<>();
        for (int key:map.keySet()) {
            ret.add(map.get(key));
        }
        return ret;
    }
}
