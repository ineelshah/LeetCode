class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int r = matrix.length;
        int c = matrix[0].length;
        
        
        
        int[] arr = new int[r * c];
        List<List<Integer>> list = new ArrayList<>();
        
        
        boolean direction = false; 
        for(int ptr = 0; ptr < r; ptr++) {
            int i = ptr;
            int j = 0;
            List<Integer> subList = new ArrayList<>();
            while(i >= 0 && j < c) {
                subList.add(matrix[i][j]);
                i--;
                j++;
            }
            
            
            
            if(direction == true) {
                Collections.reverse(subList);
                list.add(subList);
                direction = false;
            } else if(direction == false) {
                list.add(subList);
                direction = true;
            }
        }
        
        for(int ptr = 1; ptr < c; ptr++) {
            int i = r - 1;
            int j = ptr;
            List<Integer> subList = new ArrayList<>();
            
            while(j < c && i >= 0) {
                subList.add(matrix[i][j]);
                i--;
                j++;
            }
            if(direction == true) {
                Collections.reverse(subList);
                list.add(subList);
                direction = false;
            } else {
                list.add(subList);
                direction = true;
            }
        }
        
        int ptr = 0;
        for(List<Integer> subList: list) {
            for(Integer num: subList) {
                arr[ptr++] = num;
            }
        }
        return arr;
        
    }
}