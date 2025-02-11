class Solution {
    public int numberOfOne(int num)
    {
        int setBits = 0;

        // num greater than Zero
        while(num > 0)
        {
            // for each AND remove trailing setBits (num & num-1)
            num = ( num & (num - 1) );

            // one Bit canceled
            setBits++;
        }

        return setBits;
    }

    public int[] countBits(int n) 
    {
        int[] countingBits = new int[n + 1];

        // for 1 to N
        for(int i=1; i<=n; i++)
        {
            // count Number of One's
            int setBits = numberOfOne(i);

            // set Count
            countingBits[i] = setBits;
        }

        return countingBits;
    }
}