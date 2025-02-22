class Solution {
    public int threeSumClosest(int[] nums, int target) 
    {
        // no need of Exact Sum - Closest Sum
        int closestSum = Integer.MAX_VALUE;

        // Sort the nums - Two Pointer
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++)
        {
            // skip Duplicate Elements
            if(i > 0 && nums[i] == nums[i-1])
                continue;

            // perform Two-Sum II 
            int l = i + 1, r = nums.length - 1;
            while(l < r)
            {
                // calculate Triplet Sum
                int curSum = nums[i] + nums[l] + nums[r];

                // CurSum is Closest to Target - Abs(target - curSum)
                if(Math.abs(target - curSum) < Math.abs(target - closestSum))
                {
                    // update Closest Triplet Sum
                    closestSum = curSum;
                }
                
                // Special Case : found Target
                if(curSum == target)
                {
                    // return Exact Target Sum
                    return closestSum;
                }

                // Sum less than 0 - Increase Sum
                else if(curSum < target)
                {
                    l++;
                }

                // Sum greater than 0 - Decrease Sum
                else
                {
                    r--;
                }
            }
        }
        // Closest Triplet Sums to Target
        return closestSum;
    }
}