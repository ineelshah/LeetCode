class Solution {
    public int compareVersion(String version1, String version2) {
        String[] vers1 = version1.split("[.]");
        String[] vers2 = version2.split("[.]");
        // System.out.println(vers1[0] + " " + vers1[1]);
        // System.out.println(vers2[0] + " " + vers2[1]);
        int i = 0;
        int j = 0;
        while(i < vers1.length && j < vers2.length) {
            if(Integer.valueOf(vers1[i]) > Integer.valueOf(vers2[i])) {
                return 1;
            }
            
            if(Integer.valueOf(vers1[i]) < Integer.valueOf(vers2[i])) {
                return -1;
            }
            i++;
            j++;                
        }
        
        
        while(i < vers1.length) {
            if(Integer.valueOf(vers1[i]) != 0)
                return 1;
            i++;
        }
        
        
        
        while(j < vers2.length) {
            if(Integer.valueOf(vers2[j]) != 0)
                return -1;
            j++;
        }
        return 0;
    }
}