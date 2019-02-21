 O(n2)
 *********************************************************
 public int minStep(int n){
            int[] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 0;
            for (int i = 2; i <= n; i++){
                int temp = Integer.MAX_VALUE;
                if (i % 2 == 0) temp = Math.min(temp, dp[i/2]+1);
                else if ( i % 2 != 0) {
                    temp = Math.min(temp, dp[(i+1)/2]+2);
                    temp = Math.min(temp, dp[(i-1)/2]+2);
                }
                dp[i] = temp;
            }
            return dp[n];
        }
}        
