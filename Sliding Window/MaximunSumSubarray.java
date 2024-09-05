class Solution {
    public int maxSubArray(int[] nums) {
        // -Ve Infinity for comparison
        int maxSum = Integer.MIN_VALUE;
        
        // start from here or exclude
        int curSum = 0;

        for(int num : nums)
        {
            // include prev or Start new subArray from here
            curSum = Math.max(num, curSum + num);

            // Maximum Sum of Subarray
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}