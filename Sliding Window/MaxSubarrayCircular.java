class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // Max and Min subarray sums
        int maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;

        // Total sum of the array
        int total = 0;  

        // Current subarray Max and Min sums
        int curMax = 0, curMin = 0;  

        // Kadene's Algorithm
        for (int n : nums) 
        {
            /*
                Update current max and min, 
                    ( start new, prev Sum + cur )
            */
            curMax = Math.max(curMax + n, n);
            curMin = Math.min(curMin + n, n);

            // Update overall max and min sums
            maxSum = Math.max(maxSum, curMax);
            minSum = Math.min(minSum, curMin);

            // calculate total sum
            total += n;
        }

        /*
            circularSum = Total - MinSum   1] -2 [3, 4
        */
        int circularSum = total - minSum;

        // If circularSum is 0, return regular maxSum
        if (circularSum == 0) 
            return maxSum;

        // maximum of regular max sum and circular sum
        return Math.max(maxSum, circularSum);
    }
}
