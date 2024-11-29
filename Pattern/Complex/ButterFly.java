public class Solution 
{
    /*
                        *                 *
                        * *             * *
                        * * *         * * *
                        * * * *     * * * *
                        * * * * * * * * * *
                        * * * *     * * * *
                        * * *         * * *
                        * *             * *
                        *                 *
    */

    public void butterFly(int n) 
    {
        // No. of Spaces to print Each Line
        int nOfS = 2 * n;

        // decrease nOfS by 2
        nOfS -= 2;

        // row : 1 to N
        for (int i = 1; i <= n; i++) 
        {
            // print stars for I times : 1 to I
            for (int j = 1; j <= i; j++) 
            {
                System.out.print("* ");
            }

            // print Spaces nOfS times : nOfS to 0
            for (int j = nOfS; j > 0; j--) 
            {
                System.out.print("  ");
            }

            // print stars again for I times
            for (int j = 1; j <= i; j++) 
            {
                System.out.print("* ");
            }

            // decrease nOfS by 2s
            nOfS -= 2;

            System.out.println();
        }

        /* LOWER M PATTERN */

        // reset nOfS to 2
        nOfS = 2;

        // row : N - 1 to 1
        for (int i = n - 1; i >= 1; i--) 
        {
            // print stars for I times : I to 1
            for (int j = i; j >= 1; j--) 
            {
                System.out.print("* ");
            }

            // print Spaces nOfS times : 0 to nOfS
            for (int j = 0; j < nOfS; j++) 
            {
                System.out.print("  ");
            }

            // print stars again for I times
            for (int j = i; j >= 1; j--) 
            {
                System.out.print("* ");
            }

            // increase nOfS by 2
            nOfS += 2;

            System.out.println();
        }
    }
}
