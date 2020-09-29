class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        if(k <= 1)
            return 0;
        
        int currProd = 1;
        int left = 0;
        
        int count = 0;
        
        for(int right = 0; right < nums.length; right++) {
            currProd *= nums[right];
            while(currProd >= k) {
                currProd /= nums[left++];
            }
            count += right - left + 1;
        }
        return count;
    }
}