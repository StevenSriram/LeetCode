class Solution {
    public long bonusExp(int[] monster) 
    {
        int n = monster.length;
        /*
            Odd - gets monster[i] Exp
               
               base : max Exp = 1x Monster[0]
        */
        long oddMax = monster[0];  

        /*
            Even - gets 2 * monster[i] Exp

                base : max Exp = 0 (can't get 2x Monster[0])
        */
        long evenMax = 0;       
        
        for (int i = 1; i < n; i++) 
        {
            // 1x -> MAX(odd, prev Even + monster[i])
            long newOdd = Math.max(oddMax, evenMax + monster[i]);

            /// 2x -> MAX(even, prev Odd + 2 * monster[i])
            long newEven = Math.max(evenMax, oddMax + 2 * monster[i]);
            
            // Update current Max
            oddMax = newOdd;
            evenMax = newEven;
        }
        
        // Bonus Exp = MAX(odd, even)
        return Math.max(oddMax, evenMax);  
    }
}