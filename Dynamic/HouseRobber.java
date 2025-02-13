class Solution {
    public int rob(int[] nums) {
        // Dynamic Programming

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