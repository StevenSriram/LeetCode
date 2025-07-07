class Solution {
    int[][] dp;

    public int maxCoins(int[] nums) 
    {
        int n = nums.length;

        // new Ballons with padding of 1 at both ends
        int[] newNums = new int[n + 2];        

        // DP : memoize repeated Calculations
        dp = new int[n + 2][n + 2]; 

        newNums[0] = 1;
        newNums[n + 1] = 1;

        // Copy original nums 
        for (int i = 0; i < n; i++)
            newNums[i + 1] = nums[i];

        // burstBallons( first and last balloon )
        return burstBalloons(1, n, newNums);
    }

    public int burstBalloons(int l, int r, int[] coins) 
    {
        // Cross Over : No balloons to burst
        if (l > r)
            return 0; 

        // If already computed, return Value
        if (dp[l][r] != 0)
            return dp[l][r]; 

        int maxCollect = 0;

        /*
            1 [3, 2, 5, 8] 1
               L   i    R

            what happend if we burst balloon (2) last?
                coins[L - 1] * coins[i] * coins[R + 1]
            
            + burstBalloons(L, i - 1)
            + burstBalloons(i + 1, R)
        */

        // Try bursting each balloon in range [l, r]
        for (int i = l; i <= r; i++) 
        {
            // Coins earned by bursting balloon i at Last
            int curCoin = coins[l - 1] * coins[i] * coins[r + 1];

            // Recursively compute coins from left and right subarrays
            int remaining = burstBalloons(l, i - 1, coins)
                          + burstBalloons(i + 1, r, coins);

            maxCollect = Math.max(maxCollect, curCoin + remaining);
        }

        // Update maximum Coins 
        dp[l][r] = maxCollect; 

        return dp[l][r];
    }
}
