public class Solution 
{
    /*
                        * * * * *
                        *       *
                        *       *
                        *       *
                        * * * * *
    */

    public void hollowRectangle(int n) 
    {
        // row : 1 to N
        for (int i = 1; i <= n; i++) 
        {
            // col : 1 to N
            for (int j = 1; j <= n; j++) 
            {
                // print - first Row or Col , last Row or Col
                if (i == 1 || j == 1 || i == n || j == n) 
                {
                    System.out.print("* ");
                } 
                // print Space
                else 
                {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }
}
