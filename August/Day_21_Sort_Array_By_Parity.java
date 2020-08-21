class Solution {
    public int[] sortArrayByParity(int[] A) {
        
        if(A.length == 1)
            return A;
        
        int i = 0;
        int j = A.length - 1;
                
        while(i < j)
        {
            while(i < j && A[i] % 2 == 0)
                i++;
            
            while(i < j && A[j] % 2 != 0)
                j--;
            
            if(i < j)
            {
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
                j--;
                i++;
            }
        }
        
        return A;
    }
}