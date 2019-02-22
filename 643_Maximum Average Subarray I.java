Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
********************************************************************
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = Integer.MIN_VALUE;
        double res = 0;
        for (int i = 0; i<nums.length-k+1; i++){
            int Sum = 0;
            for (int j = 0; j<k ; j++){
                Sum = Sum + nums[i+j];
            }
             if (Sum > sum){
                sum = Sum;
             }
        }
        return res = (double) sum/k;
    }
}
