class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] squared = new int[nums.length];
        int i = 0, j = nums.length - 1;
        int k = squared.length - 1;
        while(i <= j) {
            if(Math.abs(nums[i]) > Math.abs(nums[j])) {
                squared[k--] = nums[i] * nums[i];
                i++;
            } else {
                squared[k--] = nums[j] * nums[j];
                j--;
            }
        }
        return squared;
    }
}