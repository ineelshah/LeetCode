class Solution {
    public boolean isPowerOfFour(int num) {
        if (num == 1)
            return true;
        double number = (float)num;
        while(number >= 4.0)
        {
            if(number == 4.0)
                return true;
            number = number / 4.0;
        }
        return false;
    }
}