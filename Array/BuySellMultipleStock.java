class Solution {
    // Multiple Transaction Allowed
    public int maxProfit(int[] prices) 
    {
        int profit = 0;

        // start from 1 go until end
        for(int i = 1; i < prices.length; i++)
        {
            // check this is Profitable - cur Greated than prev
            if(prices[i - 1] < prices[i])
            {
                // calculate profit ( i-1 : BUY    i : SELL)
                profit += (prices[i] - prices[i - 1]);
            }
        }

        // profit of Multiple transaction
        return profit;
    }
}