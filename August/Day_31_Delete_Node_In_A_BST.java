/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) 
            return root;
        
        if (root.val == key) {
            
            if (isLeaf(root)) {
                return null;
            } else if (root.right == null || root.left == null) {
                return root.right == null ? root.left : root.right;
            } else {
                root.val = inOrderSuccessor(root.right);
                root.right = deleteNode(root.right, root.val);
                return root;
            }
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }

    private static int inOrderSuccessor(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        return root.left != null ? inOrderSuccessor(root.left) : root.val;
    }
    
    private boolean isLeaf(TreeNode node) {
        if(node.left == null && node.right == null)
            return true;
        return false;
    }
    
    
    
    
}