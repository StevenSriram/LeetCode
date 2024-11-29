public class Solution 
{
    /*
                        * * * * *
                        * * * *
                        * * *
                        * *
                        *
    */

    public void reverseRightTriangle(int n) 
    {
        // row : N to 1
        for (int i = n; i >= 1; i--) 
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
