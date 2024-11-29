public class Solution {
    /*
                * * * * *
                 * * * *
                  * * *
                   * *
                    *
    */
    public void reversePyramid(int n)
    {
        // row : 1 to N
        for(int i = 1; i <= n; i++)
        {
            // col : 1 to N
            for(int j = 1; j <= n; j++)
            {
                // Row <= Col
                if(i <= j)
                {
                    /* first Row prints N Star */
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
