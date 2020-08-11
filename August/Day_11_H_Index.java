class Solution {
    public int hIndex(int[] citations) {
        
        Arrays.sort(citations);
        
        int len = citations.length;
        int l = 0;
        int h = len - 1;
        
        while(l <= h)
        {
            int mid = (l + h) / 2;
            if(citations[mid] == len - mid)
                return len - mid;
            else if(citations[mid] < len - mid)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return len - l;
        
    }
}