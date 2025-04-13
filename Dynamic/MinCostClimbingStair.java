class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        /*
          One : 
                cost to reach top from Last (cost[n-1])
          Two : 
                cost to reach top, (0) already there
        */
        int one = cost[n - 1], two = 0;

        // Traverse from second Last Step
        for (int i = n - 2; i >= 0; i--) 
        {
            // Calculate Min cost to reach top from cur Step
            int cur = cost[i] + Math.min(one, two);

            // Move the previous Step forward
            two = one;
            one = cur;
        }

        // Return Min Cost from Step 0 or Step 1
        return Math.min(one, two);
    }
}
