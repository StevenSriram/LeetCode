class Solution {
    public int[] twoSum(int[] nums, int target) {
        // left - right Pointer
        int l = 0, r = nums.length - 1;

        while(l < r)
        {
            int total = nums[l] + nums[r];
            // lesser : +Value
            if(total < target)
                l++;
            // greater : -Value
            else if(total > target)
                r--;
            // matches total == target
            else
                break;
        }
        // return positions
        return new int[]{l+1 ,r+1};
    }
}