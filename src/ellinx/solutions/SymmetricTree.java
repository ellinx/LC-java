package ellinx.solutions;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 *       1
 *      / \
 *     2   2
 *    / \ / \
 *   3  4 4  3
 *   
 * But the following [1,2,2,null,3,null,3] is not:
 *   
 *       1
 *      / \
 *     2   2
 *      \   \
 *       3   3
 *       
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * @author Ellinx
 *
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if (root==null) 
            return true;
        
        return check(root.left, root.right);
    }
    
    private boolean check(TreeNode a, TreeNode b) {
        if (a==null && b==null) 
            return true;
        
        if (a==null || b==null) 
            return false;
        
        if (a.val!=b.val)
            return false;
        
        return check(a.left,b.right) && check(a.right,b.left);
    }
}
