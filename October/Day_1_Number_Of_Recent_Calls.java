class RecentCounter {

    List<Integer> list;
    
    public RecentCounter() {
        list = new ArrayList<>();
    }
    
    public int ping(int t) {
        list.add(t);
        Integer[] arr = new Integer[list.size()];
        arr = list.toArray(arr);
        int leftIndex = binarySearch(t - 3000, arr, 0, list.size());
        return list.size() - leftIndex;
    }
    
    
    private int binarySearch(int t, Integer[] arr, int start, int end) {
        
        int ans = 0; 
        
        while (start <= end) 
        { 
            int mid = (start + end) / 2; 
            
            if (arr[mid] < t) 
                start = mid + 1; 

            else
            { 
                ans = mid; 
                end = mid - 1; 
            } 
        } 

        return ans; 
        
    }
    
    
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */