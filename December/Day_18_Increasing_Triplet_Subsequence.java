class Solution {
    public boolean increasingTriplet(int[] nums) {
	    if(nums == null || nums.length < 3) return false;
        int mini = Integer.MAX_VALUE;
        int medi = Integer.MAX_VALUE;
        for(int num: nums) {
            if(num < mini) {
                mini = num;
            } else if(num > mini && num < medi) {
                medi = num;
            } else if(num > medi) {
                return true;
            }
        }
        return false;
    }
}