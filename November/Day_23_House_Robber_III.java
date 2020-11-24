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
    Map<TreeNode, Integer> hmap = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        if(hmap.containsKey(root)) return hmap.get(root);
        int grandchildren = 0;
        if(root.left != null) grandchildren = grandchildren + rob(root.left.left) + rob(root.left.right);
        if(root.right != null) grandchildren = grandchildren + rob(root.right.left) + rob(root.right.right);
        hmap.put(root, Math.max(root.val + grandchildren, rob(root.left) + rob(root.right)));
        return hmap.get(root);
        
    }
}