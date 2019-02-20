You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*************************************************************************************
class Solution {
    public int climbStairs(int n) {
        return climbStairs(n, new int[n+1]);
    }
    private int climbStairs(int n, int[] cache){
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (cache[n] > 0) return cache[n];
        return cache[n] = climbStairs(n-1, cache) + climbStairs(n-2, cache);
    }
}
