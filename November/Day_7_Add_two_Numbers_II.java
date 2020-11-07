class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);        
        int lastDivisor = 0;
        return binarySearch(nums, threshold);
    }
    
    private int getSum(int[] nums, int divisor) {
        int sum = 0;
        for(int num: nums){
            sum += Math.ceil((float)num / (float)divisor);
        }
        return sum;
    }
    
    private int binarySearch(int[] nums, int threshold) {
        int left = 0;
        int right = nums[nums.length - 1];
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int sum = getSum(nums, mid);
            if(sum > threshold) {
                left = mid + 1;
            } else {
                right = mid - 1;    
            }    
        }
        
        // at the end of loop, left > right,
        // computeSum(right) > threshold
        // computeSum(left) <= threshold
        // --> return left
        return left;
        
    }
    
}