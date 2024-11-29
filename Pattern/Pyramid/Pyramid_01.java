public class Solution 
{
    /*
                            1
                           0 1
                          1 0 1
                         0 1 0 1
                        1 0 1 0 1
    */
    public void pyramid_01(int n) 
    {
        // row : 1 to N
        for (int i = 1; i <= n; i++) 
        {
            // spaces : I to N - 1
            for (int j = i; j < n; j++) 
            {
                System.out.print(" ");
            }

            // col : 1 to I
            for (int j = 1; j <= i; j++) 
            {
                // EVEN sum - print 1
                if ((i + j) % 2 == 0) 
                {
                    System.out.print("1 ");
                } 
                // ODD sum - print 0
                else 
                {
                    System.out.print("0 ");
                }
            }

            System.out.println();
        }
    }
}
