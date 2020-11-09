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
    public int maxAncestorDiff(TreeNode root) {
        int a = 0, b = 0;
        if(root.left != null) a = util(root.left, root.val, root.val, 0);
        if(root.right != null) b = util(root.right, root.val, root.val, 0);
        return Math.max(a, b);
    }
    
    private int util(TreeNode root, int maxSoFar, int minSoFar, int best) {
        
        System.out.println(root.val + " " + maxSoFar + " " + minSoFar);
        
        if(root.left != null & root.right != null) {
            int a = util(root.left, Math.max(root.val, maxSoFar), Math.min(root.val, minSoFar), Math.max(best, Math.max(maxSoFar - root.val, root.val - minSoFar)));
            int b = util(root.right, Math.max(root.val, maxSoFar), Math.min(root.val, minSoFar), Math.max(best, Math.max(maxSoFar - root.val, root.val - minSoFar)));
            return Math.max(a, b);
        }
        
        if(root.left != null)        
            return util(root.left, Math.max(root.val, maxSoFar), Math.min(root.val, minSoFar), Math.max(best, Math.max(maxSoFar - root.val, root.val - minSoFar)));
        
        if(root.right != null) 
            return util(root.right, Math.max(root.val, maxSoFar), Math.min(root.val, minSoFar), Math.max(best, Math.max(maxSoFar - root.val, root.val - minSoFar)));
        
        return Math.max(best, Math.max(maxSoFar - root.val, root.val - minSoFar));
        
    }
    
}