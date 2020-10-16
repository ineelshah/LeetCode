class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix == null || matrix.length == 0)
            return false;
        
        int m = matrix.length  - 1;
        int n = matrix[0].length - 1;
        
        int i = 0;
        int j = n;
        
        while(  (i >=0 && i<=m) && (j>=0 && j<=n)  ){
            int curr = matrix[i][j];
            if(curr == target)return true;
            if(target > curr){
                i++;
            }else{
               j--; 
            }
        } 
       return false;
    }
}