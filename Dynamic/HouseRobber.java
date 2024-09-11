class Solution {
    public int rob(int[] nums) {
        // Dynamic Programming

        // rob1 - prev-adjacent / rob2 - adjacent
        int rob1 = 0, rob2 = 0;

        for(int house : nums)
        {
            /*
                [ rob1, rob2, n, ... ]
                we can ROB rob1 with current rob / 
                 ROB rob2 without rob current
            */
            int curRob = Math.max( house + rob1 , rob2);
            // change rob1, rob2 to adjacent
            rob1 = rob2;
            rob2 = curRob;
        }
        // retutn Maximum ROB
        return rob2;
    }
}