class Solution {
    public int change(int amount, int[] coins) 
    {
         int n = coins.length;

        // i : coins    j : amount
        // include coin one by one and check change for amount
        int[][] dp = new int[n + 1][amount + 1];

        // 0 : amount can be achive in One Way (without taking any Coin)
        for(int i=0; i<=n; i++)
        {
            dp[i][0] = 1;
        }

        // Fill Table
        for(int i = 1; i <=n ; i++)
        {  
            for(int j = 1; j <= amount; j++)
            {
                // amount less than curCoin - fill no. ways from above
                if(j < coins[i-1])
                {
                    dp[i][j] = dp[i-1][j];
                }
                /*
                    1) No. ways by Excluding curCoin
                    2) No. ways by Including curCoin
                    3) Sum( Exclude , Include )
                */
                else
                {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }                
            }
        }

        // return No. of ways Coin Change can be achived
        return dp[n][amount];
    }
}