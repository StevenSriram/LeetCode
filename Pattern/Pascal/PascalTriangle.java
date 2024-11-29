/*
    *   Pascal's Triangle is a triangular array of the binomial coefficients.
    *   It has many important properties and applications in combinatorics, algebra, and geometry.
*/

public class Solution 
{
    /*
                1
               1 1
              1 2 1
             1 3 3 1
            1 4 6 4 1
    */

    public void pascalTriangle(int n) 
    {
        // generate all Rows {1 ... N}
        for (int i = 1; i <= n; i++) 
        {
            // print Spaces
            for (int j = i; j < n; j++) 
            {
                System.out.print(" ");
            }

            // each Row Value
            generateRow(i);
        }
    }

    public void generateRow(int n) 
    {
        // default print - 1
        System.out.print("1 ");

        long ans = 1;

        // loop for curRow : 1 based Index
        for (int i = 1; i < n; i++) 
        {
            /*
                n = 5
                                    I = 1
                                  4/1 = 4
                            4x3 / 1x2 = 6
                        4x3x2 / 1x2x3 = 4
                    4x3x2x1 / 1x2x3x4 = 1

                CurRow : [1, 4, 6, 4, 1]
            */

            // multiply (N - I) [5 - 1]
            ans *= (n - i);

            // divide (I) [4 / 1]
            ans /= (i);

            // print cur Value
            System.out.printf("%d ", ans);
        }

        System.out.println();
    }
}
