class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> list = new ArrayList<>();
        if(nums.length == 0) {
            return list;
        }
        Arrays.sort(nums);
        int starts = 0;
        int ends = 0;
        for(int i = 0; i < nums.length; i++) {
            int j = i + 1;
            if(i == nums.length - 1) {
                list.add(String.valueOf(nums[i]));
            } else {
                if(nums[i] + 1 == nums[j]) {
                    starts = i;
                    while(j < nums.length) {
                        if(nums[j] != nums[i] + 1) break;
                        i = j;
                        j++;
                    }
                    list.add(String.valueOf(nums[starts] + "->" + nums[i]));
                }
                else {
                    list.add(String.valueOf(nums[i]));
                }
            }
        }
        return list;
    }
}