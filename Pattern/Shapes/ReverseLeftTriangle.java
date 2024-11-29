public class Solution 
{
    /*
                        * * * * *
                          * * * *
                            * * *
                              * *
                                *
    */

    public void reveseLeftTriangle(int n) 
    {
        // row : 1 to N
        for (int i = 1; i <= n; i++) 
        {
            // col : 1 to N
            for (int j = 1; j <= n; j++) 
            {
                // Row <= Col
                if (i <= j) 
                {
                    /* first Row prints N Star */
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
