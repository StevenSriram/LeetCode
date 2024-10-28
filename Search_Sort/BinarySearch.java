class Solution {
    public int search(int[] nums, int target) 
    {
        // left - First     right - Last
        int l = 0, r = nums.length-1;

        // l & r - not CrossOver
        while(l <= r)
        {
            // calculate Middle
            int mid = (l + r) / 2;

            // target equals Mid element
            if(nums[mid] == target)
            {
                return mid;
            }
            // target less than Mid element - Search on first Part
            else if(target < nums[mid])            
            {
                r = mid - 1;
            }
            // target great than Mid element - Search on second Part
            else
            {
                l = mid + 1;
            }
        }

        // Not Found : -1
        return -1;
    }
}