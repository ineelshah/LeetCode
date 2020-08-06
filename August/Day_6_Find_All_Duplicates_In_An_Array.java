// The trick is to negate the value in the array, which is at the index {curr_number - 1}, since all elements in  the array are from 1 to the // size of the array.
// Refer: NICK WHITE's YouTube video for more details.


class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < nums.length ; i++)
        {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0)
                ans.add(Math.abs(nums[i]));
            
            nums[index] *= -1;
            
        }
        return ans;
    }
}


/*
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums.length - 1; i++)
        {
            
            if(nums[i] == nums[i + 1])
                ans.add(nums[i]);
            
        }
        return ans;
    }
}
*/
