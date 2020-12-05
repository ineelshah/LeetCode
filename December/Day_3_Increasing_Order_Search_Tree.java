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
    TreeNode resultNode;
    public TreeNode increasingBST(TreeNode root) {
        resultNode = new TreeNode();
        TreeNode resultNodeHead = resultNode;
        getInorder(root);
        return resultNodeHead.right;
        
    }
    
    private void getInorder(TreeNode root) {
        if(root == null) 
            return;
        getInorder(root.left);
        resultNode.right = new TreeNode(root.val);
        resultNode = resultNode.right;
        getInorder(root.right);        
    }
    
}