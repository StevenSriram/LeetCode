class Solution {
    public int minimumSwaps(int[] nums) 
    {
        // minSwaps to make Sorted
        int totalSwaps = 0;
        
        for(int i=0; i<nums.length; i++)
        {
            // number is already Visited
            if(nums[i] == -1)
                continue;
                
            /* Descending Order : 

                if(nums[i] == n - i)
                    (n - i) correct Sorted place

                int nextIdx = n - nums[idx] 
                    (n - nums[idx]) correct nextIdx [1 based Numbering]
            */

            // number already in its correct Sorted Place
            if(nums[i] == i + 1)
            {
                // mark Visited
                nums[i] = -1;
                continue;
            }
            
            // start a Cycle from Idx
            int cycleEdge = 0, idx = i;
            
            // visited Idx again (CYCLE)
            while(nums[idx] != -1)
            {
                // calculate nextIdx
                int nextIdx = nums[idx] - 1;
                
                // mark Visited - cycleEdge++
                nums[idx] = -1;
                cycleEdge++;
                
                // move to nextIdx
                idx = nextIdx;
            }
            
            // CycleEdge - 1 : Swaps required to Make it Sorted
            totalSwaps += cycleEdge - 1;
        }
        
        return totalSwaps;
    }
}