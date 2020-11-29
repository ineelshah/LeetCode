class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        HashSet<Integer> visited = new HashSet<>();
        
        while(!queue.isEmpty()) {
            
            int currIndex = queue.remove();
            
            
            int left = currIndex - arr[currIndex];
            int right = currIndex + arr[currIndex];
            
            if(left >= 0 && !visited.contains(left)) {
                queue.add(left);
                visited.add(left);
            }
            if(right < arr.length && !visited.contains(right)) {
                queue.add(right);
                visited.add(right);
            }
            if(arr[currIndex] == 0) 
                return true;
        }
        
        
        
        return false;
        
    }
}