class Solution
{
    public List<Integer> majorityElement(int[] nums)
    {
        // Boyer-Moore Voting - Majority elements
        List<Integer> majority = new ArrayList<>();

        /*
            There maybe two candidates that occurs more than  [n / 3] times
            
                [1, 2, 3, 2, 3] - {2 : 2, 3 : 2}  
                            2 > 5 / 3 (1.6)
        */

        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        // Find two candidates that could possibly appear more than n/3 times
        for (int vote : nums)
        {
            // Vote equals current candidate - increment count
            if (vote == candidate1)
            {
                count1++; 
            }
            else if (vote == candidate2)
            {
                count2++; 
            }

            // Count is 0 - this new candidate has same count as previous
            else if (count1 == 0)
            {
                // Update new candidate - this may be the majority
                candidate1 = vote; 
                count1 = 1;
            }
            else if (count2 == 0)
            {
                candidate2 = vote; 
                count2 = 1;
            }

            // Vote doesn't match current candidate - decrement count
            else
            {
                count1--;
                count2--;
            }
        }

        // Reset counts to verify actual occurrences
        count1 = count2 = 0;

        /*
            Since there is no gaurenteed of Majority Elemets, 
            we need to verity wheter this is actual Majority or Not

                [1, 2, 3, 4, 5] - 5 is pointed as Candidate but Not
        */

        // Count actual occurrences of two candidates
        for (int vote : nums)
        {
            if (vote == candidate1)
            {
                count1++;
            }
            else if (vote == candidate2)
            {
                count2++;
            }
        }

        // If candidate appears more than n/3 times, add to result
        if (count1 > nums.length / 3)
        {
            majority.add(candidate1);
        }

        if (count2 > nums.length / 3)
        {
            majority.add(candidate2);
        }

        return majority;
    }
}
