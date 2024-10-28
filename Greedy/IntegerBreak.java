class Solution {
    /* 
        Break Integer as, as Many 3's we can
            - because breaking into 3 gives as maximum product 
    */

    public int integerBreak(int n) 
    {
        // n = 2 ( 1 + 1 ) product [1]
        if(n == 2) return 1;

        // n = 3 ( 1 + 2 ) product [2]
        if(n == 3) return 2;

        // n is completely divided by 3 - product [3 ^ n/3] 
        if(n % 3 == 0)
            return (int) Math.pow(3, n/3);

        /* n divided by 3 give reminder 1 replace one 3 with 4 to maximize product 
            [3 ^ n/3] * 1 is lesser so, replace one 3 with 4 [3 ^ n/3 - 1] * 4
        */
        if(n % 3 == 1)
            return (int) Math.pow(3, n/3 - 1) * 4;

        // n divided by 3 give reminder 1 - product [3 ^ n/3] * 2
        if(n % 3 == 2)
            return (int) Math.pow(3, n/3) * 2;

        // n is Zero
        return 0;
    }
}