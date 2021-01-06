class Solution {
    public int findKthPositive(int[] arr, int k) {
        int ans = 0;
        if(k < arr[0]) 
            return k;
        
        if(arr[0] != 1) {
            k -= (arr[0] - 1);
        }
        
        // System.out.println(k);
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] != arr[i + 1] - 1) {
                int oldK = k;
                k -= (arr[i + 1] - arr[i] - 1);
                System.out.println(k);
                if(k < 0) {
                    return arr[i] + oldK;
                }
                if(k == 0) {
                    return arr[i + 1] - 1;
                }
            }
        }
        return arr[arr.length - 1] + k;
    }
}