class Solution {
    public int hammingWeight(int n) {
        int setBits = 0;

        /*
            every n & n-1 - one Zero is cancels out
            11 - 1011
            10 - 1010 &
                 1010

            10 - 1010
             9 - 1001 &
                 1000

             8 - 1000
             7 - 0111 &
                 0000
        */

        while(n != 0)
        {
            setBits++;
            n = n & (n-1);
        }

        // No. 1 Bits
        return setBits;
    }
}