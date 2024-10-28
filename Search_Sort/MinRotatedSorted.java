class Solution {
    public int findMin(int[] nums) 
    {
        // Binary Search Varient
        int l = 0, r = nums.length - 1;

        int minVal = Integer.MAX_VALUE;

        // not Cross Over
        while(l <= r)    
        {
            /* left less than right - Normal Sorted Array
                   Minimum at left */
            if(nums[l] < nums[r])
            {
                minVal = Math.min(minVal, nums[l]);
                break;
            }

            // Find Mid of rotated sorted array
            int mid = (l + r) / 2;

            // check Mid is minimum
            minVal = Math.min(minVal, nums[mid]);

            /* Left Sorted Portion */ 
                // left is less than mid - part of First Sorted array
                if(nums[l] <= nums[mid])
                {
                    // min is at Second part
                    l = mid + 1;
                }
                
            /* Right Sorted Portion */ 
                else
                {
                    // min is at First part
                    r = mid - 1;
                }
        }

        // Minimum in Rotated Sorted array
        return minVal;
    }
}