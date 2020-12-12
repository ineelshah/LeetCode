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
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        
        int leftDepth = getDepth(root.left, 0);
        int rightDepth = getDepth(root.right, 0);
        
        if(leftDepth == rightDepth) 
            return root;
        
        if(leftDepth > rightDepth) {
            return subtreeWithAllDeepest(root.left);
        }
        else if(rightDepth > leftDepth) {
            return subtreeWithAllDeepest(root.right);
        }
        
        return root;
    }
    
    private int getDepth(TreeNode node, int depth) {
        if(node == null) 
            return depth;
        
        int leftDepth = getDepth(node.left, depth + 1);
        int rightDepth = getDepth(node.right, depth + 1);
        return Math.max(leftDepth, rightDepth);
    }    
}