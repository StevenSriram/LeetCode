public class Solution {
    /*
               *       *
                 *   *
                   *
                 *   *
               *       *
    */

    public void xPattern(int n) 
    {
        // row : 1 to N
        for (int i = 1; i <= n; i++) 
        {
            // col : 1 to N
            for (int j = 1; j <= n; j++) 
            {

                /*
                    Negative Diagonal -> i == j

                    Positive Diagonal -> ( i + j ) == N + 1
                */
                if (i == j || (i + j) == n + 1) 
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
