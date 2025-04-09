class Solution {
    public boolean canPartition(int[] nums) 
    {
        int n = nums.length;

        // calculae Total Sum nums
        int total = Arrays.stream(nums).sum();

        // total is ODD - can't Partition
        if(total % 2 != 0)
            return false;

        /*
            Target = total / 2 (half)

            one Half present, second half also present
        */
        int target = total / 2; 

        // Optimized 1 DP -> targetSum size
        boolean[] dp = new boolean[target+1];

        // initalize 0 sum can be achivable
        dp[0] = true;

        /* 
            Similar to Sum of Subsets but previous sum
                is present inf cur dp[i]
        */
        for(int num : nums)
        {
            // j >= target -> we changes DP
            for(int j=target; j>=num; j--)
            {
                /*
                    DP[i] = sum achived in Prev DP[i] ||
                            sum achive by including cur DP[i - num]
                */
                dp[j] = dp[j] || dp[j - num];
            }
        }

        // return Half Partition - Found
        return dp[target];
    }
}