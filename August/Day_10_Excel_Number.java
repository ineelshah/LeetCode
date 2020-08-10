class Solution {
    public int titleToNumber(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length - 1;
        int colNumber = 0;
        for(int i = n; i >= 0; i--)
        {
            int alphabetValue = arr[i] - 'A' + 1;
            colNumber += alphabetValue * Math.pow(26, n - i);
        }
        
        return colNumber;
        
    }
}