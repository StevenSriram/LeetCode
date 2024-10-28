class Solution {
    public int findPeakElement(int[] nums) 
    {
        /* Binary Search based on Max value
               Max Value guaranted Peak Element */
        int l = 0, r = nums.length - 1;

        while(l <= r)    
        {
            // find Middle
            int mid = (l + r) / 2;

            // left num is greater - Peak on Left
            if(mid > 0 && nums[mid - 1] > nums[mid])
            {
                r = mid - 1;
            }
            // right num is greater - Peak on Right
            else if(mid < nums.length - 1  && nums[mid + 1] > nums[mid])
            {
                l = mid + 1;
            }
            // Peak Element Found
            else
            {
                return mid;
            }
        }

        // No Peak Element
        return -1;
    }
}