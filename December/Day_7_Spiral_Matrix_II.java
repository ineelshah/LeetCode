class Solution {
    public int[][] generateMatrix(int n) {
        
        int count = 1;
        
        int[][] matrix = new int[n][n];
        
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int i = 0, j = 0;
        
        while(top <= bottom && left <= right) {
            i = top;            
            for(j = left; j <= right; j++) {
                matrix[i][j] = count;
                count++;
                // printMatrix(matrix);
            }
            j = right;
            for(i = top + 1; i <= bottom; i++) {
                matrix[i][j] = count;
                count++;
                // printMatrix(matrix);
            }
            i = bottom;
            for(j = right - 1; j >= left; j--) {
                matrix[i][j] = count;
                count++;
                // printMatrix(matrix);
            }
            j = left;
            for(i = bottom - 1; i >= top + 1; i--) {
                matrix[i][j] = count;
                count++;
                // printMatrix(matrix);
            }
            top++;
            bottom--;
            left++;
            right--;
            
        }
        
        
        return matrix; 
        
    }
    
    private void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");                
            }
            System.out.println();
        }
        System.out.println();
    }
    
}