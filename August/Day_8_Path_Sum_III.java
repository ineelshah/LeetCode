class Solution {
    int ans = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        
        calcSum(root, sum);
        
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        
        return ans;
    }
    
    
    private void calcSum(TreeNode root, int sum)
    {
        if(root == null)
            return;
        
        if(root.val == sum)
            ans++;
        
        calcSum(root.left, sum - root.val);
        calcSum(root.right, sum - root.val);
        
    }
    
}