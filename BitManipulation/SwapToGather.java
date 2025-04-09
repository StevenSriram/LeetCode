public class Solution {
    /* Minimum no. swaps to gather all '1's together at Middle */
    public long swapToGather(String str) 
    {
        // Count total no. of '1's
        int right = 0;
        for (char ch : str.toCharArray()) 
        {
            right += (ch == '1') ? 1 : 0;
        }
        
        // Minimum number of swaps needed
        long minSwaps = 0;
        
        // Track 1's encountered so far
        int left = 0;

        // Iterate over string        
        for (char ch : str.toCharArray()) 
        {
            // Char  is '1'
                if (ch == '1') 
                {
                    // increment 1's count so Far
                    left++;  

                    // decrement '1' from total
                    right--; 
                } 
            
            // Char is '0'
                else 
                {
                    // Add minimum of left and right to swaps
                    minSwaps += Math.min(left, right); 
                    /*
                        left - 1                 right - 2
                                \               /
                                swaping left 1's 
                                to '0' needs minSwaps
                    */ 
                }
        }
        
        return minSwaps; 
    }
}
