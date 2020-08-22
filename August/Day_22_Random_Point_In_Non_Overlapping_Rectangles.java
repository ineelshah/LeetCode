class Solution {

    int[] staggeredSum;
    Map<Integer, int[]> hmap; 
    
    public Solution(int[][] rects) {
        
        staggeredSum = new int[rects.length];
        hmap = new HashMap<>();
        
        int j = 0;
        int sum = 0;
        
        for(int[] rect: rects)
        {
            int size = (rect[3] - rect[1] + 1) * (rect[2] - rect[0] + 1);
            sum += size;
            hmap.put(j, rect);
            staggeredSum[j] = sum;
            j++;
        }    
        
    }
    
    public int[] pick() {
        
        Random random = new Random();
        
        int index = random.nextInt(staggeredSum[staggeredSum.length - 1]);
        
        int[] currRect = hmap.get(getRectangle(index));
        
        int x1 = currRect[0];
        int y1 = currRect[1];
        int x2 = currRect[2];
        int y2 = currRect[3];
        
        int x = random.nextInt(Math.abs(x2 - x1) + 1) + x1;
        int y = random.nextInt(Math.abs(y2 - y1) + 1) + y1;
        
        return new int[] {x, y};
        
    }
    
    private int getRectangle(int num)
    {
        int left = 0;
        int right = staggeredSum.length - 1;
        
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            
            if(staggeredSum[mid] > num)
                right = mid;
            else
                left= mid + 1;
            
        }
        return left;
        
    }
    
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */