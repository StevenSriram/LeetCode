class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        // Maximum Consective One's
        int maxOne = Integer.MIN_VALUE;
        // No. of Zero's flip
        int zeroCount = 0;
        // start of Window
        int start = 0;

        // start building Window
        for(int end = 0; end < n; end++)
        {
            // flip Zero's
            if(nums[end] == 0)
                zeroCount++;

            // flip exists K
            while(zeroCount > k)
            {
                // start new Window by removing filped Zero's
                if(nums[start] == 0)
                    zeroCount--;

                start++;
            }

            // maxmimum Window Length
            maxOne = Math.max(maxOne, end - start + 1);
        }
        return maxOne;
    }
}