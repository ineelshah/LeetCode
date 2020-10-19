class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        
        List<Integer> list = new ArrayList<>();
        list.add(A[0]);
        list.add(A[1]);
        list.add(B[0]);
        list.add(B[1]);
        int ans = Integer.MAX_VALUE;
        for(int a: list) {
            int temp = check(A, B, a);
            if(temp != -1)
                ans = Math.min(ans, temp);
            
            temp = check(B, A, a);
            if(temp != -1)
                ans = Math.min(ans, temp);
        }
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
        
    }
    
    private int check(int[] A, int[] B, int a) {
        
        int count = 0;
        
        for(int i = 0; i < A.length; i++) {
            if(a != A[i]) {
                if(a == B[i]) {
                    count++;
                }
                else return -1;
            }
        }
        return count;
    }    
}