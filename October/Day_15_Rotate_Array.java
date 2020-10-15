class Solution {
    public void rotate(int[] nums, int k) {
        k = k % (nums.length);
        nums = reverse(nums, 0, nums.length - 1);
        nums = reverse(nums, 0, k - 1);
        nums = reverse(nums, k, nums.length - 1);
    }
    private int[] reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }
}