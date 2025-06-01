public class Solution {
    /*
        Wine gets more value when getting older.

        We can only sell one bottle at a time: either from the left or right.
        The value of wine gets higher every year.

        prices = [1, 4, 2, 3]

        Example optimal selling:
            3 * 1 = 3
            1 * 2 = 2
            2 * 3 = 6
            4 * 4 = 16

        MAX_PROFIT = 29
    */

    // DP : Memoization the Recursive call
    int[][] dp;

    public int sellingWineBottles(int[] prices) 
    {
        int n = prices.length;
        dp = new int[n][n];
        
        // [0 - N-1] range, Year
        return maxProfit(prices, 0, n - 1, 1);
    }

    public int maxProfit(int[] prices, int l, int r, int Y) 
    {
        // if Already calculated
        if (dp[l][r] != 0)
        {
            // return from DP
            return dp[l][r];
        }
        
        // BASE CASE : Only one Bottle
        if (l == r)
        {
            // return Price * Year
            return prices[l] * Y;
        }
        
        // leftP = price at left * cur Year + maxProfit([L+1, R], Y+1)
        int leftPrice = prices[l] * Y + 
                            maxProfit(prices, l + 1, r, Y + 1);

        // rightP = price at right * cur Year + maxProfit([L, R-1], Y+1)
        int rightPrice = prices[r] * Y + 
                            maxProfit(prices, l, r - 1, Y + 1);

        // Memo : result in DP[L][R]
        dp[l][r] = Math.max(leftPrice, rightPrice);

        // return MaxProfit of [L, R]
        return dp[l][r];
    }
}
