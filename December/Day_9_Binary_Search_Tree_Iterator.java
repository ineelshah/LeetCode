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
class BSTIterator {
    List<Integer> inorder;
    int curr;
    public BSTIterator(TreeNode root) {
        inorder = new ArrayList<>();
        curr = 0;
        traverseInorder(root);
    }
    
    public int next() {
        return inorder.get(curr++);
    }
    
    public boolean hasNext() {
        if(curr >= inorder.size()) return false;
        return true;
    }
    
    private void traverseInorder(TreeNode root) {
        if(root == null)
            return;
        traverseInorder(root.left);
        inorder.add(root.val);
        traverseInorder(root.right);
    }    
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */