package solutions;

/**
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n==0) {
            return null;
        }
        return buildTree(preorder, 0, n-1, inorder, 0, n-1);
    }
    private TreeNode buildTree(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
        if (s1>e1 || s1<0 || s1>=preorder.length) {
            return null;
        }
        TreeNode ret = new TreeNode(preorder[s1]);
        int idx = 0;
        for (int i=s2;i<=e2;i++) {
            if (inorder[i]==preorder[s1]) {
                idx = i;
                break;
            }
        }
        ret.left = buildTree(preorder, s1+1, e1-(e2-idx), inorder, s2, idx-1);
        ret.right = buildTree(preorder, e1-(e2-idx)+1, e1, inorder, idx+1, e2);
        return ret;
    }
}
