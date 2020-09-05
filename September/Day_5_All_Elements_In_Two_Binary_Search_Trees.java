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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> tree1 = new ArrayList<>();
        List<Integer> tree2 = new ArrayList<>();
        
        traverse(root1, tree1);
        traverse(root2, tree2);
        return merge(tree1, tree2);
    }
    
    private void traverse(TreeNode root, List list) {
        if(root == null) return;
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }
    
    private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while(i < list1.size() && j < list2.size()) {
            if(list1.get(i) <= list2.get(j)) {
                result.add(list1.get(i++));                
            }
            else if(list1.get(i) > list2.get(j)) {
                result.add(list2.get(j++));                   
            }
        }
        
        
        while(i < list1.size()) {
            result.add(list1.get(i++));
        }
        
        while(j < list2.size()) {
            result.add(list2.get(j++));
        }
        
        
        return result;
    }
    
}