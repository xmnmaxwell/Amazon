Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
给一个数组把偶数放前面，奇数放后面
*********************************************************************************************
//O(N) + O(1) space
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        // we compare A[i] % 2 and A[j] % 2
        //四中情况：00说明j的位置不正确，01说明位置正确，10说明颠倒过来位置正确，11说明i的位置不正确。
        while (i < j){
            if (A[i] % 2 > A[j] % 2) { // 10情况
                swap(A, i, j);
                i++;
                j--;
            }
            if (A[i] % 2 == 0) i++;//有点逆向思维，A[i]是偶数，说明位置正确，继续前进
            if (A[j] % 2 != 0) j--;//A[j]是奇数说明位置正确，继续前进
        }
        return A;
    }
    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
