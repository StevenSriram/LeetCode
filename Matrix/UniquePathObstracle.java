class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) 
    {
        // We can Only move ( Right and Down )
        /* m - ROW      n - COL */
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        // DP : of each Row
        int[] dp = new int[n];

        // we can able to reach value itself by (1 - way)
        dp[n - 1] = 1;

        // Reverse Grid in Reverse Order
        for(int i = m-1; i >= 0; i--)
        {
            // In each iteration the Down Value is stored in DP itself
            for(int j = n-1; j >= 0; j--)
            {
                // if Obstracle - No Ways to Reach
                if(obstacleGrid[i][j] == 1)
                    dp[j] = 0;

                // check if column is not at end - can't move to Right
                else if(j + 1 < n)
                    dp[j] = dp[j] + dp[j+1];

                /*
                else
                    dp[j] = dp[j]; // Only Down Value
                */
            }
        }

        // return No. Unique Ways to Reach End
        return dp[0];
    }
}