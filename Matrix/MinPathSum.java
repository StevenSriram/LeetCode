class Solution {
    // Similar to Unique Path
    public int minPathSum(int[][] grid) 
    {
        // m - ROW   &   n - COL
        int m = grid.length, n = grid[0].length;

        // DP - of Row , every time we depend on Prev Row only
        int[] dp = new int[n];

        // intialize with Maximum Value
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Last value - 0 (Not Path)
        dp[n - 1] = 0;

        // Reverse Grid in Reverse Order
        for(int r = m-1; r >= 0; r--)
        {
            // In each iteration the Down Value is stored in DP itself
            for(int c = n-1; c >= 0; c--)
            {
                // check if column is not at end - move Down, Right
                if(c + 1 < n)
                {
                    // MIN( Down, Right )  + Grid[value]
                    dp[c] = grid[r][c] + Math.min(dp[c] , dp[c + 1]);
                }

                // column End - can't move to Right
                else
                {
                    // only Down + Grid[value]
                    dp[c] = grid[r][c] + dp[c];
                }
            }
        }

        // Minimum to Reach END
        return dp[0];
    }
}