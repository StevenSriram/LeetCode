class Solution {
    public int maxProfit(int[] prices) {
        // profit Generated
        int profit = 0;
        int buy = prices[0];

        for(int sell : prices)
        {
            /*
                Buy at minimum price
                Sell at maximum price
            */
            buy = Math.min(buy, sell);

            // Profit = Sell - Buy
            profit = Math.max(profit, sell - buy);
        }
        return profit;
    }
}