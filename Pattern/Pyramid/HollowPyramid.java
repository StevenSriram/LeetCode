public class Solution 
{
    /*
                                    *
                                   * *
                                  *   *
                                 *     *
                                * * * * *
    */

    public void hollowPyramid(int n) 
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
                    /* first Row prints 1 Star */
                    if (i == 1 || i == j || j == n) 
                    {
                        /*
                                print on Last Row and Last Col ,
                                        both Row and Col equals
                        */
                        System.out.print("* ");
                    } 
                    // Space Inside Pyramid
                    else 
                    {
                        System.out.print("  ");
                    }
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
