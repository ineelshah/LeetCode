class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix == null || matrix.length == 0)
            return false;
        
        int r = matrix.length - 1;
        int c = matrix[0].length - 1;
        
        int i = 0;
        int j = c;
        
        while(i <= r && j >= 0) {
            int curr = matrix[i][j];
            if(curr == target)
                return true;
            else if(target > curr) {
                i++;
            }
            else {
               j--; 
            }
        } 
       return false;
    }
}