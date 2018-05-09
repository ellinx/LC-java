package ellinx.solutions;

/**
 * Given a complete binary tree, count the number of nodes.
 * 
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, 
 * and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * @author Ellinx
 *
 */
public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
        if (root==null) return 0;
        
        int lh=1, rh=1;
        TreeNode l = root.left;
        TreeNode r = root.right;
        while (l!=null) {
            lh++;
            l = l.left;
        }
        while (r!=null) {
            rh++;
            r = r.right;
        }
        if (lh==rh) return (1<<lh)-1;
        
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
