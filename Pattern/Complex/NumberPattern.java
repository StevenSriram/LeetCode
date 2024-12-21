public class Solution
{
    /*
            1 6 10 13 15 
            2 7 11 14 
            3 8 12 
            4 9 
            5 
    */

   public void numberPattern(int n) 
    {
        // Row : 1 to N
        for(int i = 1; i <= n; i++) 
        {
            /* 
                1 (1+5) 
                6 (6+4) 
                10 (1+3) 
                13 (13+2) 
                15
            */

            // ? Number to Add from n-- each step
            int add = n;

            // Previous Number to Add
            int prev = i;

            // Intially Every Row Starts with I
            System.out.print(i + " ");

            // Remaining N - 1
            for(int j = i; j < n; j++) 
            {
                prev += add;

                // ! Cur = Prev + Add
                System.out.print(prev + " ");
                add--;
            }
            System.out.println();
        }
    }
}