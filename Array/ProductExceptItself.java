class Solution {
    public int[] productExceptSelf(int[] nums) {
        // space O(1) - prefix and postfix uses same array
        int[] res = new int[nums.length];

        // Prefix array
        int prefix = 1;
        for(int i=0; i<nums.length; i++)
        {
            res[i] = prefix;
            prefix *= nums[i];
        }

        // Postfix array
        int postfix = 1;
        for(int i=nums.length-1; i>=0; i--)
        {
            res[i] *= postfix;
            postfix *= nums[i];
        }

        return res;
    }
}