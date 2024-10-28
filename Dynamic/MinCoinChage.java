class Solution {
    /* Dynamic Programming : 
                reduction of Bigger problem into smaller Sub  ,
                Memoize the repeated Sub Problems
    */
    public int coinChange(int[] coins, int amount) 
    {
        int n = coins.length;

        // i : coins    j : amount
        // include coin one by one and check change for amount
        int[][] dp = new int[n + 1][amount + 1];

        // fill Table with MAX_VALUE
        for(int[] row : dp)
            Arrays.fill(row, 99999);

        // 0 : amount can be achive without any Coins
        for(int i=0; i<=n; i++)
        {
            dp[i][0] = 0;
        }

        // Fill Table
        for(int i = 1; i <=n ; i++)
        {  
            for(int j = 1; j <= amount; j++)
            {
                // amount less than curCoin - fill from above
                if(j < coins[i-1])
                {
                    dp[i][j] = dp[i-1][j];
                }
                /*
                    1) Exclude curCoin
                    2) Include curCoin and check remaining coin Change
                    3) Min( Exclude , Include + 1 {remaining change + curCoin} )
                */
                else
                {
                    dp[i][j] = Math.min(
                                dp[i-1][j],
                                1 + dp[i][j - coins[i-1]]
                            );
                }                
            }
        }

        // can't get Change -1
        if(dp[n][amount] == 99999)
            return -1;

        // print the Min Coin Change 
        int i = n, j = amount;
        while(i > 0 && j > 0)
        {
            // different : this coin included in MinCoin
            if(dp[i][j] != dp[i-1][j])
            {
                System.out.println(coins[i-1]);
                j -= coins[i-1];
            }
            // this coin excluded form MinCoin
            else
            {
                i--;
            }
        }
        // return min No. Coins required
        return dp[n][amount];
    }
}