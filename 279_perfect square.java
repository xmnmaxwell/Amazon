Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
    O(n2)
********************************************
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i * i <= n; i++){
            dp[i*i] = 1; // for all the square numbers, their dp is 1. this is to set boundary condition.
        }
        for (int i = 0; i <= n; i++){
            for (int j = 1; j*j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
