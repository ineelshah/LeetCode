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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(root, val);
    }
    
    private TreeNode insert(TreeNode root, int val) {
        
        if(root == null) {
            root = new TreeNode(val);
        }
        
        if(val > root.val) {
            root.right = insert(root.right, val);
        }
        
        if(val < root.val) {
            root.left = insert(root.left, val);
        }
        
        return root;
    }
    
}