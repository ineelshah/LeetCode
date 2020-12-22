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
    boolean result;
    public boolean isBalanced(TreeNode root) {
        result = true;
        if(root == null) return true;
        int a = root.left != null ? depth(root.left, 1) : 0;
        int b = root.right != null ? depth(root.right, 1) : 0;
        if(a - b > 1 || b - a > 1) return false;
        return result;
    }
    private int depth(TreeNode root, int depth) {
        if(root == null) return depth;
        int a = root.left != null ? depth(root.left, depth + 1) : depth;
        int b = root.right != null ? depth(root.right, depth + 1) : depth;
        if(a - b > 1 || b - a > 1) {
            result = false;
        }
        return Math.max(a, b);
    }
    
}