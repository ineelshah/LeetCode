class Solution {
    public boolean buddyStrings(String A, String B) {
        int countOne = -1;
        int countTwo = -1;
        int count = 0; 
        if(A.length() != B.length() || A.length() < 2) {
            return false;
        }
        boolean isEqual = true;;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i = 0; i < A.length(); i++) {
            arr1[A.charAt(i) - 'a']++;
            arr2[B.charAt(i) - 'a']++;
            if(A.charAt(i) != B.charAt(i)){
                isEqual = false;
                if(countOne == -1) countOne = i;
                else countTwo = i;
                count++;
            }
        }
        
        if(isEqual) {
            for(int i = 0; i < arr1.length; i++) {
                if(arr1[i] >= 2) {
                    return true;
                }
            }
            return false;
        }
        
        if(count == 2) {
            if((A.charAt(countOne) + A.charAt(countTwo) - B.charAt(countOne) - B.charAt(countTwo)) == 0)
                return true;
        }
        
        return false;
        
    }
}