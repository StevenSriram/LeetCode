public class Solution 
{
    /*
                                    *
                                   * *
                                  * * *
                                 * * * *
                                * * * * *
                                 * * * *
                                  * * *
                                   * *
                                    *
    */

    public void diamond(int n) 
    {
        // row : N to 1
        for (int i = n; i >= 1; i--) 
        {
            // col : 1 to N
            for (int j = 1; j <= n; j++) 
            {
                if (i <= j)
                    System.out.print("* ");
                else
                    System.out.print(" ");
            }

            System.out.println();
        }

        // row : 1 to N - 1
        for (int i = 1; i <= n - 1; i++) 
        {
            /* Space for Alignment of Lower Pyramid */
            System.out.print(" ");

            // col : 1 to N - 1
            for (int j = 1; j <= n - 1; j++) 
            {
                if (i <= j)
                    System.out.print("* ");
                else
                    System.out.print(" ");
            }

            System.out.println();
        }
    }
}
