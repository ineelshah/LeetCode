class Solution {
    public int longestMountain(int[] A) {
        if(A.length < 3) return 0;
        int biggestSoFar = 0;
        boolean flip = false;
        int upward = 0;
        for(int i = 1; i < A.length; i++) {
            upward = 0;
            if(A[i] > A[i - 1]) {
                while(i < A.length && A[i] > A[i - 1]) {
                    i++;
                    upward++;
                }
                flip = true;
                // System.out.println(upward);
            }
            if(i < A.length && flip == true && A[i] < A[i - 1]) {
                // System.out.println("i: " + i);
                flip = false;
                int count = upward + 1;
                while(i < A.length && A[i] < A[i - 1]) {
                    // System.out.println(A[i] + " " + A[i - 1]);
                    i++;
                    count++;
                }
                i--;
                // System.out.println(count);
                biggestSoFar = Math.max(biggestSoFar, count);
            }
            if(i < A.length && flip == true && A[i] >= A[i - 1]) {
                flip = false;
            }
        }
        return biggestSoFar;
    }
}