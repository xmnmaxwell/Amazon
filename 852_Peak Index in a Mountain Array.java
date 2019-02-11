Input: [0,2,1,0]
Output: 1
******************************************************
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int res = 0;
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (A[mid] < A[mid+1]){  
                start = mid + 1;  
            } else {
                end = mid;
            }
        }
        if (A[start] > A[end]) res = start;
        else res = end;
        return res;
    }
}
