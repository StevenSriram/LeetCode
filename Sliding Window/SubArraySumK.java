class Solution {
    public boolean subarraySum(int[] nums, int target) {
        int n = nums.length;
        
        // Consider Sub Array of Size - 1
        int start = 0;
        int end = 0;
        
        // that is first element - (nums[0])
        int sum = nums[0];
        
        // check Inbounds
        while(end < n)
        {
            // Sum Matches Target
            if(sum == target)
            {
                return true;
            }
            
            // Sum less than Target
            else if(sum < target)
            {
                // increase Sub Array size
                end++;
                
                // check Bounds - add Sum
                sum += end < n ? nums[end] : 0; 
            }
            
            // Sum exceeds Target
            else
            {
                // decrease Sub Array Sum
                sum -= nums[start];

                // move to next Sub Array
                start++;
            }
        }
        
        // Sum Not Found
        return false;
    }
}
