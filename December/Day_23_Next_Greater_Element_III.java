class Solution {
    public int nextGreaterElement(int n) {
        String num = String.valueOf(n);
        int[] arr = new int[num.length()];
        int i = 0;
        for(char c: num.toCharArray()) {
            arr[i++] = c - '0';
        }
        for(int j = arr.length - 1; j >= 0; j--) {
            if(j > 0 && arr[j] <= arr[j - 1]) {
                continue;
            } else if(j == 0) {
                return -1;
            } else {
                int numToChange = arr[j - 1];
                int indexForNumToChangeWith = -1;
                for(int p = j; p < arr.length; p++) {
                    if(indexForNumToChangeWith == -1 || arr[p] > numToChange && arr[p] < arr[indexForNumToChangeWith]) {
                        indexForNumToChangeWith = p;
                    }
                }
                
                // System.out.println(numToChange + " " + arr[indexForNumToChangeWith]);
                swap(arr, j - 1, indexForNumToChangeWith);
                Arrays.sort(arr, j, arr.length);
                StringBuilder sb = new StringBuilder();
                for(int numb: arr) {
                    sb.append(numb);
                    // System.out.println(numb);
                }
                
                Long answer = Long.valueOf(sb.toString());
                return answer > Long.valueOf(Integer.MAX_VALUE) ? -1 : Integer.valueOf(sb.toString());  
                    
            }
        }
        return -1;
    }
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}