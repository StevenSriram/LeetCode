class Solution {
    // Time : 0( n log k )

    /*
        n - Size of Piles
        k - Eating speed per Hour

        Binary Search on Eating Speed 0(log k)
    */
    public int minEatingSpeed(int[] piles, int h)
    {
        // Base : Minimum Eating Speed
        int l = 1;

        // Maximum Eating Speed
        int r = Arrays.stream(piles).max().orElse(0);

        // Koko Eating Speed to eat all Piles
        int minEatingSpeed = r;

        // Binary Search on Eating Speed
        while(l <= r)
        {
            // mid Eating Speed
            int k = (l + r) / 2;

            // hours Spent on cur Eating Speed
            int hourSpent = 0;

            // for each pile
            for(int p : piles)
            {
                // hours to Eat cur Pile
                hourSpent += Math.ceil( (double) p / k );
                // { Piles / Cur Speed }
            }

            // hours Spent less than equal to Total Hours
            if(hourSpent <= h)
            {
                // update Koko Speed
                minEatingSpeed = Math.min(minEatingSpeed, k);

                // check for further Min Koko Spedd
                r = k - 1;
            }
            else
            {
                // check for Greater Min Koko Spedd
                l = k + 1;
            }
        }

        return minEatingSpeed;
    }
}