class Solution {
    public int majorityElement(int[] nums) 
    {
        // Boyer-Moore Voting Algorithm
        int count = 0, candidate = 0;

        /*
            Guaranteed that one element appears more than [n / 2] times.

            If not, Boyer-Moore Voting won't work.
                Example: [1, 2, 1, 2]  - {1 : 2, 2 : 2}

            Both 1 and 2 appear exactly n/2 times - such input is invalid.
        */

        for(int vote : nums)
        {
            // Vote equals current candidate - increment count
            if(candidate == vote)
                count++;

            // Count is 0 - this new candidate has same count as previous
            else if(count == 0)
            {
                // Update new candidate - this may be the majority
                candidate = vote;
                count = 1;
            }

            // Vote doesn't match current candidate - decrement count
            else
                count--;
        }

        // Return majority candidate
        return candidate;
    }
}
