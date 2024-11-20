class Solution {
    public int removeElement(int[] nums, int val) 
    {
        // left Start on Arrays
        int l = 0;

        // traverse Right
        for(int r = 0; r < nums.length; r++)    
        {
            // number at right equal to value to Remove - Continue
            if(nums[r] == val)
                continue;

            // move Right to Left - inc left
            nums[l] = nums[r];
            l++;
        }

        // return LEFT
        return l;
    }
}