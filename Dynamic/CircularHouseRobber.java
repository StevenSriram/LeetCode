class Solution {
    public int rob(int[] nums) 
    {
        // only One House return itSelf - skiping both first & last
        if(nums.length == 1)
            return nums[0];

        /*
             robbery from start_House to skipping last_House
             robbery from skipping start_Houe till last_House
        */
        return Math.max(
            robHelper(nums, 0, nums.length-1),
            robHelper(nums, 1, nums.length)
        );
    }

    // House Robber - breaking of Sub-Problem based on two previous Robbery 
    public int robHelper(int[] nums, int start, int end)
    {
        /*
            Rob1 - Maxmium ROB until prev-prev house (2-step previous)
            Rob2 - Maxmium ROB until prev house (1-step previous)
        */
        int rob1 = 0, rob2 = 0;

        // rob1 - rob2 [ h, h+1, h+2 ... h+n]
        for(int i=start; i<end; i++)
        {
            int house = nums[i];

            /*
                either ROB current_House + prev prev House (rob1)
                    skip current_House ROB prev House (rob2)
            */
            int curRob = Math.max(house + rob1, rob2);

            // maintain what Amount we can ROB Up_and_till this House

            /* set rob1 (prev-prev) to rob2 (prev) */
            rob1 = rob2;
            /* set rob2 (prev) to CurRob (cur) */
            rob2 = curRob; 
        }
        // maximum ROBBERY
        return rob2;
    }
}