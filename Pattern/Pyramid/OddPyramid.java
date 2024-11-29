public class Solution 
{
    /*
                                 *
                               * * *
                             * * * * *
                           * * * * * * *
                         * * * * * * * * *
    */

    public void oddPyramid(int n) 
    {
        // N = Double N
        n = 2 * n;

        // row : 1 to N
        for (int i = n; i >= 1; i -= 2) // i -= 2 { ODD pyramid }
        {
            // col : 1 to N
            for (int j = 1; j <= n; j++) 
            {
                // Row <= Col
                if (i <= j) 
                {
                    /* first Row prints 1 Star */
                    System.out.print("* ");
                }

                // Space
                else 
                {
                    /* Print only One Space */
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}
