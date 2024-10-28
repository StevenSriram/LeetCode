class Solution {
    public boolean search(int[] nums, int target) 
    {
        /* Rotated Sorted Array : Main moto find Sorted portion
                [4, 0, (1) ,2, 3]
            guarantied than any one Portion is sorted after finding Mid
        */
        int l = 0, r = nums.length - 1;

        // handle single element [1]
        while(l <= r)    
        {
            int mid = (l + r) / 2;

            // target Found
            if(nums[mid] == target)
                return true;

            /* Only problem with Duplicates are,
                what if all left, mid, right are Same */
            if(nums[l] == nums[mid] && nums[mid] == nums[r])
            {
                // shrink Array and Continue
                l++;  r--;
                continue;
            }

            // left sorted Portion
            if(nums[l] <= nums[mid])
            {
                // target falls b/w left and mid - First Portion
                if(nums[l] <= target && target <= nums[mid])
                {
                    r = mid - 1;
                }
                // rotated target falls in Second Portion
                else
                {
                    //  (sorted continued in Second Potion)
                    l = mid + 1;
                }
            }
            // right sorted Portion
            else
            {
                // target falls b/w mid and right - Second Portion
                if(nums[mid] <= target && target <= nums[r])
                {
                    l = mid + 1;
                }
                // rotated target falls in First Portion
                else
                {
                    //  (sorted continued in First Potion)
                    r = mid - 1;
                }
            }
        }
        // target Not Found
        return false;
    }
}