public class Solution 
{
    /*
                        *
                        * *
                        * * *
                        * * * *
                        * * * * *
    */

    public void rightTriangle(int n) 
    {
        // row : 1 to N
        for (int i = 1; i <= n; i++) 
        {
            // col : 1 to I
            for (int j = 1; j <= i; j++) 
            {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}
