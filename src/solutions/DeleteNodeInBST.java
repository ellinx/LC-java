package solutions;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. 
 * Return the root node reference (possibly updated) of the BST.
 * 
 * Basically, the deletion can be divided into two stages:
 * 
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 * 
 * Example:
 * 
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * 
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 *
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * Another valid answer is [5,2,6,null,4,null,7].
 *
 *    5
 *   / \
 *  2   6
 *   \   \
 *    4   7
 *
 */
public class DeleteNodeInBST {
	public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null)
        	return null;
        if (root.val < key){
        	root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
        	root.left = deleteNode(root.left, key);
        } else {
        	if (root.left==null) {
        		root = root.right;
        	} else if (root.right==null) {
        		root = root.left;
        	} else {
        		TreeNode node = findMax(root.left);
        		root.val = node.val;
        		root.left = deleteNode(root.left, node.val);
        	}
        }
        return root;
    }
	private TreeNode findMax(TreeNode root) {
		if (root==null)
			return null;
		
		if (root.right==null)
			return root;
		
		return findMax(root.right);
	}
	
	public TreeNode deleteNode2(TreeNode root, int key) {
        if (root==null)
            return null;
        //step1:find the node
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur!=null && cur.val!=key) {
            parent = cur;
            if (cur.val>key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        //step2:remove node
        if (parent==null) {
            return merge(root.left, root.right);
        }
        if (parent.left!=null && parent.left.val==key) {
            parent.left = merge(parent.left.left, parent.left.right);
        } else if (parent.right!=null && parent.right.val==key) {
            parent.right = merge(parent.right.left, parent.right.right);
        }
        return root;
    }
    private TreeNode merge(TreeNode node1, TreeNode node2) {
        //System.out.println(node1.val+","+node2.val);
        if (node1==null && node2==null) {
            return null;
        }
        if (node1!=null && node2==null) {
            return node1;
        }
        if (node1==null && node2!=null) {
            return node2;
        }
        TreeNode parent = node1;
        TreeNode cur = node1.right;
        while (cur!=null) {
            parent = cur;
            if (node2.val>cur.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        //System.out.println(parent.val+":"+node2.val);
        if (parent.val<node2.val) {
            parent.right = node2;
        } else {
            parent.left = node2;
        }
        return node1;
    }
}
