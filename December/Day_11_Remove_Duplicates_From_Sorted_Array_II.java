class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 2;
        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] == nums[i + 2]) {
                nums[i] = Integer.MAX_VALUE;
            } else {
                count++;
            }
        }
        Arrays.sort(nums);
        return count;
    }
}