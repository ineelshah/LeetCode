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
    public boolean isValidBST(TreeNode root) {
        return validate(root.left, root.val, null) && validate(root.right, null, root.val);
    }
    
    
    private boolean validate(TreeNode node, Integer maxValue, Integer minValue) {
        if(node == null) 
            return true;
        
        if((maxValue != null && node.val >= maxValue) || (minValue != null && node.val <= minValue)) {
            return false;            
        }
        
        // System.out.println(node.val);
        return validate(node.left, maxValue != null ? Math.min(node.val, maxValue) : node.val, minValue) && validate(node.right, maxValue, minValue != null ? Math.max(node.val, minValue) : node.val);
    }
    
}