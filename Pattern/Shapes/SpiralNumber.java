public class Solution
{
    /*
            1 1 1 1 1 
            1 2 2 2 1 
            1 2 3 2 1 
            1 2 2 2 1 
            1 1 1 1 1 
    */
    public int findMin(int i, int j, int n)
    {
        /*
            Top : I - 1, Bottom : N - I
            Left : J - 1, Right : N - J
        */
        int top = i - 1, bot = n - i;
        int lef = j - 1, rig = n - j;

        /* for Reverse (N) Pattern -> findMax among all + 1 */
        
        // Min among all + 1
        return Math.min(top , Math.min(bot, Math.min(lef, rig))) + 1;
    }
    
    public void spiralNumber(int n) 
    {
        // I : 1 to N
        for(int i = 1; i <= n; i++)
        {
            // J : 1 to N
            for(int j = 1; j <= n; j++)
            {
                /* Print - Minimum of all 4 Direction */
                System.out.printf("%d ", findMin(i, j, n));
            }
            System.out.println();
        }
    }
}