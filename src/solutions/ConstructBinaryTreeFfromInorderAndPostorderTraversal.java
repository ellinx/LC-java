package solutions;

/**
 * 
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class ConstructBinaryTreeFfromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    private TreeNode helper(int[] inorder, int s1, int e1, int[] postorder, int s2, int e2) {
        if (s1>e1) {
            return null;
        }
        if (s1==e1) {
            return new TreeNode(inorder[s1]);
        }
        TreeNode ret = new TreeNode(postorder[e2]);
        int i1 = findIndex(inorder, s1, e1, postorder[e2]);
        if (i1==s1) {
            ret.right = helper(inorder, s1+1, e1, postorder, s2, e2-1);
            return ret;
        }
        int i2 = s2+i1-s1-1;
        ret.left = helper(inorder, s1, i1-1, postorder, s2, i2);
        ret.right = helper(inorder, i1+1, e1, postorder, i2+1, e2-1);
        return ret;
    }
    
    private int findIndex(int[] arr, int s, int e, int target) {
        for (int i=s;i<=e;i++) {
            if (arr[i]==target) {
                return i;
            }
        }
        return -1;
    }
}
