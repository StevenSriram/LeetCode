class Solution {
    public boolean canJump(int[] nums) {
        // Optimal Greedy - Time : O(n)

        // Goal index
        int goal = nums.length - 1;

        // check for prev index whether we reach Goal from here
        for(int i=nums.length - 1; i>=0; i--)
        {
            /*
                i - Current index   nums[i] - Jump index  
                    ( Current + Jump = Goal )
            */
            if(i + nums[i] >= goal)
            {
                // update new Goal
                goal = i;
            }
        }
        // return True if reached Start else False
        return goal == 0;
    }
}