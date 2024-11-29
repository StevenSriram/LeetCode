public class Solution 
{
    /*
                                *
                              * *
                            * * *
                          * * * *
                        * * * * *
    */

    public void leftTriangle(int n) 
    {
        // row : N to 1
        for (int i = n; i >= 1; i--) 
        {
            // col : 1 to N
            for (int j = 1; j <= n; j++) 
            {
                // Row <= Col
                if (i <= j) 
                {
                    /* first Row only print one Star */
                    System.out.print("* ");
                } 
                // Space
                else 
                {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }
}
