public class Solution 
{
    /*
                            *
                            *
                        * * * * *
                            *
                            *
    */

    public void plusPattern(int n) 
    {
        // calculate Middle Index
        int mid = (n / 2) + 1;

        // row : 1 to N
        for (int i = 1; i <= n; i++) 
        {
            // col : 1 to N
            for (int j = 1; j <= n; j++) 
            {
                // I equals Mid or J equals Mid
                if (i == mid || j == mid)
                    System.out.print("* ");
                // space
                else
                    System.out.print("  ");
            }

            System.out.println();
        }
    }
}
