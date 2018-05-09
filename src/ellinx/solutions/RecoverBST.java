package ellinx.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note: A solution using O(n) space is pretty straight forward. Could you
 * devise a constant space solution?
 * 
 * @author Ellinx
 *
 */
public class RecoverBST {
TreeNode pre;
    
    public void recoverTree(TreeNode root) {
        List<TreeNode[]> nodes = new ArrayList<>();
        pre = null;
        inorder(root, nodes);
        if (nodes.size()==1) {
            TreeNode node1 = nodes.get(0)[0];
            TreeNode node2 = nodes.get(0)[1];
            int tmp = node1.val;
            node1.val = node2.val;
            node2.val = tmp;
        } else if (nodes.size()==2) {
            TreeNode node1 = nodes.get(0)[0];
            TreeNode node2 = nodes.get(1)[1];
            int tmp = node1.val;
            node1.val = node2.val;
            node2.val = tmp;
        } else {
            System.out.println("something wrong");
        }
    }
    
    private void inorder(TreeNode root, List<TreeNode[]> nodes) {
        if (root==null || nodes.size()==2)
            return;
        
        inorder(root.left, nodes);
        if (pre==null) {
            pre = root;
        } else {
            if (pre.val>root.val) {
                if (nodes.size()==0) {
                    TreeNode[] tn = {pre, root};
                    nodes.add(tn);
                } else {
                    TreeNode[] tn = {pre, root};
                    nodes.add(tn);
                    return;
                }
            }
            pre = root;
        }
        inorder(root.right, nodes);
    }
    
}
