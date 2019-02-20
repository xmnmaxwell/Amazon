dtermine whether number is power of two
***********************************************
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
        int p = 1;
        while (n /p >0){
            p = p * 2;
            if (n == p) {
                return true;
            }
        }
        return false;
    }
}
