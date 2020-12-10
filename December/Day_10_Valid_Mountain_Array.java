class Solution {
    public boolean validMountainArray(int[] arr) {
        int i = 0;
        boolean reachedPeak = false;
        while(!reachedPeak && i < arr.length - 1) {
            if(arr[i + 1] > arr[i]) i++;
            else if(arr[i + 1] == arr[i]) return false;
            else reachedPeak = true;
        }
        if(i == 0 || i == arr.length - 1) return false;
        while(i < arr.length - 1) {
            if(arr[i + 1] < arr[i]) i++;
            else return false;
        }
        if(i == arr.length - 1) return true;
        return false;
        
    }
}