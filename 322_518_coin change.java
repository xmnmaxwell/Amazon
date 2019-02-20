find fewest number of coins that you need to make up that amount, can use repeatedly
Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
use DP, O(amount*n) + O(amount) n, how many iterations
In the worst case the recursive tree of the algorithm has height of SS and the algorithm solves only SS subproblems 
because it caches precalculated solutions in a table. Each subproblem is computed with nn iterations, one by coin denomination. 
*********************************************************
public class Solution {

    public int coinChange(int[] coins, int amount) {        
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}
**********************************************************************************
518. compute the number of combinations that make up that amount.
O(mn)+O(mn)
dp[i][j] : the number of combinations to make up amount j by using the first i types of coins
State transition:

not using the ith coin, only using the first i-1 coins to make up amount j, then we have dp[i-1][j] ways.
using the ith coin, since we can use unlimited same coin, we need to know how many ways to make up amount j - coins[i-1] by using first i coins(including ith), which is dp[i][j-coins[i-1]]
Initialization: dp[i][0] = 1

Once you figure out all these, it's easy to write out the code:

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }
