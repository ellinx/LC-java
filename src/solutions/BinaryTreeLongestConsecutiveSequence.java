package solutions;

/**
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to 
any node in the tree along the parent-child connections. 

The longest consecutive path need to be from parent to child (cannot be the reverse).

Example 1:
Input:

   1
    \
     3
    / \
   2   4
        \
         5

Output: 3
Explanation: Longest consecutive sequence path is 3-4-5, so return 3.

Example 2:
Input:

   2
    \
     3
    / 
   2    
  / 
 1

Output: 2 
Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
 */

public class BinaryTreeLongestConsecutiveSequence {
    
    private int longestPath;
    
    public int longestConsecutive(TreeNode root) {
        longestPath = 0;
        longestFrom(root);
        return longestPath;
    }
    private int[] longestFrom(TreeNode root) {
        if (root==null) {
            return new int[]{0,0};
        }
        int[] left = longestFrom(root.left);
        int[] right = longestFrom(root.right);
        int[] ret = {root.val,1};
        if (left[1]>0 && left[0]-1==ret[0]) {
            ret[1] = left[1]+1;
        }
        if (right[1]>0 && right[0]-1==ret[0]) {
            ret[1] = Math.max(ret[1], right[1]+1);
        }
        longestPath = Math.max(longestPath, ret[1]);
        // System.out.println(root.val+","+longestPath);
        return ret;
    }
}
