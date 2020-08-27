class Solution {
    public int[] findRightInterval(int[][] intervals) {
        
        Map<Integer, Integer> hmap = new HashMap<>();
        int n = intervals.length;
        for(int i = 0; i < n; i++) {
            hmap.put(intervals[i][0], i);
        }
        
        int[] keyArray = new int[n];
        
        int k = 0;
        for(int i: hmap.keySet()) {
            keyArray[k++] = i;
        }
        
        Arrays.sort(keyArray);
        
        int[] right = new int[n];
        
        for(int i = 0; i < n; i++) {
            int currEndPoint = intervals[i][1];
            int indexOfRight = binarySearch(keyArray, 0, n, currEndPoint);
            if(indexOfRight > 0)
                right[i] = hmap.get(keyArray[indexOfRight]);
            else
                right[i] = -1;
        }
        
        return right;
        
    }
    
    private int binarySearch(int[] nums, int left, int right, int target) {
        
        while(left < right) {
            
            int mid = left + (right - left) / 2;
            
            // System.out.println(mid + " nums[mid]: " + nums[mid]);
            
            if(nums[mid] >= target && nums[mid - 1] < target)
                return mid;
            
            else if(nums[mid] > target)
                right = mid;
            
            else
                left = mid + 1;
        }
        
        return -1;
    }
    
}