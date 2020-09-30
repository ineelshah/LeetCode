class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0)
            return 1;
        boolean hasOne= false;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 1)
                hasOne = true;
            if(nums[i] <= 0 || nums[i] > nums.length)
                nums[i] = 1; // Or any arbitrary integer. We use one, and check if one already exists or not.
        }
        
        if(!hasOne) return 1;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[Math.abs(nums[i]) - 1] < 0)
                continue;
            
            nums[Math.abs(nums[i]) - 1] *= -1;
            
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > 0)
                return i + 1;
        }
        return nums.length + 1;
    }
}