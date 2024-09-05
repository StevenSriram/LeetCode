class Solution {
    public int majorityElement(int[] nums) {
        // Boyer Moore Voting Algorithm
        int count = 0, canditate = 0;

        for(int vote : nums)
        {
            // reset Canditate
            if(count == 0)
            {
                canditate = vote;
            }

            // increase or decrease Vote
            count += (vote == canditate) ? 1 : -1;
        }

        // Majority Canditate
        return canditate;
    }
}