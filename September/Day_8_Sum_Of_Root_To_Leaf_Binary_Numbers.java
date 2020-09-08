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
    List<String> list = new ArrayList<>();
    public int sumRootToLeaf(TreeNode root) {
        
        int sum = 0;
        
        traverseTree(root, new StringBuffer());
        System.out.println(list);
        for(String num: list) {
            sum += toInteger(num);            
        }
        
        return sum;
    }
    
    private void traverseTree(TreeNode node, StringBuffer sb) {
        if(node == null)
            return;
        
            
        sb.append(node.val);
        
        if(node.left == null && node.right == null) {
            list.add(sb.toString());
            return;
        }
        
        if(node.left != null) {
            traverseTree(node.left, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        
        if(node.right != null) {
            traverseTree(node.right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
    
    private int toInteger(String str) {
        char[] arr = str.toCharArray();
        int n = arr.length;
        int val = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(arr[i] == '1') {
                val += Math.pow(2, n - i - 1);
            }
        }
        return val;
    }
    
    
}