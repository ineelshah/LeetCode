class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int i = 0;
        boolean[] visited = new boolean[pieces.length];
        while(i < arr.length) {
            boolean gotValue = false;
            for(int j = 0; j < pieces.length; j++) {
                if(!visited[j] && equals(arr, pieces[j], i, i + pieces[j].length)) {
                    visited[j] = true;
                    i+=pieces[j].length;
                    gotValue = true;
                    break;
                } 
            }
            if(!gotValue) return false;
        }
        // System.out.println(i);
        if(i == arr.length) 
            return true;
        return false;
    }
    
    private boolean equals(int[] arr1, int[] arr2, int start, int end) {
        int j = 0;
        for(int i = start; i < end; i++) {
            if(arr1[i] != arr2[j++]) {
                return false;
            }
        }
        return true;
    }
    
}