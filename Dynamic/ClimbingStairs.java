class Solution 
{
    // n - No. of Stais take (1 or 2) steps
    
    public int climbStairs(int n) 
    {
        // Fibonacci Sequence from top Stair
        /* 
        Two : 
            from top there is always one to reach Top, because already in Top
        One : 
            from just before top there in one way to reach Top, by taking one step
        */
        int one = 1, two = 1;

        // we need to compute fibonacci for N-1 times
        for(int i=0; i<n-1; i++)
        {
            // move One to next fibbonacci
            int temp = one;
            one = one + two;

            // move Two to One
            two = temp;
        }
        // start of Stair
        return one;
    }
}