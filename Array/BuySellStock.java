class Solution {
    public int maxProfit(int[] prices) 
    {
        // Two Pointers ( L = BUY , R = SELL )
        int l = 0, r = 1;

        // Maximum Profit from Transcation
        int maxP = 0;

        // move right till end
        while(r < prices.length)    
        {
            // where this if Profitable Transaction
            /*
                        r *
                                =>   + Profit
                l *     
            */
            if(prices[l] < prices[r])
            {
                // calculate Profit [R - L]
                int curP = prices[r] - prices[l];

                // maximum Profit
                maxP = Math.max(maxP, curP);
            }
            else
            {
                // move Left to (least value) Right
                l = r;
            }

            // next Transaction
            r++;
        }

        return maxP;
    }
}