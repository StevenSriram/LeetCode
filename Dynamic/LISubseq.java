class Solution {
    /*
        Binary Search on DP array to find in which 
            Index the curNum to be Inserted
    */
    public int binarySearchToInsert(int[] nums, int target , int size)
    {
        // L : 0    R : len - 1
        int l = 0, r = size - 1;

        // until CrossOvers each Others
        while(l <= r)
        {
            // Efficient Inbounds Mid calculation
            int mid = l + (r - l) / 2;

            // Target found
            if(nums[mid] == target)
            {
                // Mid is Index for Num
                return mid;
            }

            // Target Less : check on Right portion
            else if(nums[mid] < target)
            {
                l = mid + 1;
            }

            // Target Great : check on Left portion
            else
            {
                r = mid - 1;
            }
        }

        // not Found : Left (End) Index of Num
        return l;
    }

    public int lengthOfLIS(int[] nums) 
    {
        // Length of Longest Increasing Subsequence
        int lenLIS = 0;

        // DP : find and insert Num in their Corresponding Index
        int[] dp = new int[nums.length];

        // take each Number
        for(int target : nums)
        {
            // find the correct Index to Insert Num
            int idx = binarySearchToInsert(dp, target, lenLIS);

            // Index exceeds length of LIS
            if(idx == lenLIS)
            {
                // found new Increasing Number
                lenLIS++;
            }
            
            // update Target in ther Index
            dp[idx] = target;
        }

        return lenLIS;
    }
}