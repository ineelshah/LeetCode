class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                hmap.put(sum, hmap.getOrDefault(sum, 0) + 1);
            }
        }
        
        int count = 0;
        for(int i = 0; i < C.length; i++) {
            for(int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                count += hmap.getOrDefault(-1 * sum, 0);
            }
        }
        return count;
    }
}