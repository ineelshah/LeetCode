class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for(Integer num: nums) {
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }
        
        
        int count = 0;
        for(Integer num: hmap.keySet()) {
            if(k == 0) {
                if(hmap.get(num) >= 2)
                    count++;
            }
            else {
                if(hmap.containsKey(k + num))
                    count++;
            }
        }
        
        return count;
    }
}