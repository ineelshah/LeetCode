class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        List<Integer> result = new LinkedList<>();
        
        for (int start = 1, end = 9; start <= end; start++) {
            fill(result, N - 1, K, start);
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    public void fill(List<Integer> result, int N, int K, int num) {        
        if (N == 0) {
            result.add(num);
            return;
        }
        
        for (int start = 0, end = 9; start <= end; start++) {
            if (Math.abs(num % 10 - start) == K) fill(result, N - 1, K, num * 10 + start);    
        }
    }
}