public class Solution 
{
    public void function(int n, int r) 
    {
        /*
                (n-1) C (r-1) = value of Pascal triangle at Specific Index

                nCr = n! / r! * (n-r)!

                7C2 = 7x6 / 1x2 => (n-r)! cancel out
        */

        long ans = 1;

        // loop for R times - 0 based index
        for (int i = 0; i < r; i++) 
        {
            // multiply (N - I) [7 x 6]
            ans *= (n - i);

            // divide (I + 1) [1, 2]
            ans /= (i + 1);
        }

        System.out.print(ans);
    }
}
