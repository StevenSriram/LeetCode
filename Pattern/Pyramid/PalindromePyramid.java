public class Solution 
{
    /*
                                 1
                               1 2 1
                            1 2 3 2 1
                          1 2 3 4 3 2 1
                        1 2 3 4 5 4 3 2 1
    */

    public void palindromePyramid(int n) 
    {
        // row : 1 to N
        for (int i = 1; i <= n; i++) 
        {
            // spaces : I to N - 1
            for (int j = i; j < n; j++) 
            {
                System.out.print("  ");
            }

            // col : 1 to I
            for (int j = 1; j <= i; j++) 
            {
                /* print left Palindrome */
                System.out.printf("%d ", j);
            }

            // col : I - 1 to 1
            for (int j = i - 1; j >= 1; j--) 
            {
                /* print right Palindrome */
                System.out.printf("%d ", j);
            }

            System.out.println();
        }
    }
}
