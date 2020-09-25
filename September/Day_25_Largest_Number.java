class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        int i = 0;
        
        for(int num: nums) {
            arr[i++] = String.valueOf(num);
        }
        
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String a, String b) {
                String str1 = a + b;
                String str2 = b + a;
                return str2.compareTo(str1);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(String a: arr) {
            sb.append(a);
        }
        if(arr[0].equals("0")) {
            return "0";
        }
        return sb.toString();       
    }
}