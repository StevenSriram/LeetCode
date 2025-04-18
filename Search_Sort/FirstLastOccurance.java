class Solution {
    // Helper for binary search for either first or last occurrence of target
    public int firstLastSearch(int[] nums, int target, boolean leftBiased)
    {
        int l = 0, r = nums.length - 1; 

        // Index to -1 (Not found)
        int idx = -1; 

        while (l <= r) 
        {
            int mid = (l + r) / 2; 

            // Move right if target is greater
            if (nums[mid] < target)
            {
                l = mid + 1; 
            }

            // Move left if target is smaller
            else if (nums[mid] > target)
            {
                r = mid - 1; 
            }
            else
            {
                // target Found - update Index
                idx = mid; 

                // If we're looking for first occurrence, move left
                if (leftBiased)
                {
                    r = mid - 1;
                }
                // Otherwise, move right to find last occurrence
                else 
                {
                    l = mid + 1;
                }
            }
        }

        return idx;
    }

    public int[] searchRange(int[] nums, int target) 
    {
        int[] res = new int[2];

        // Search first occurrence of Target
        res[0] = firstLastSearch(nums, target, true);

        // Search last occurrence of Target
        res[1] = firstLastSearch(nums, target, false);

        return res; 
    }
}
