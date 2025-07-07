public class Solution {
    /*
            1 2 3
            6 5 4
            7 8 9
     */
    public void snakeNumber(int n) 
    {
        // (L - R) : +1 or (R - L) : -1 
        int inc = 1;   
        int num = 1;    

        // I : 1 to N
        for (int i = 1; i <= n; i++) 
        {
            // J : 1 to N
            for (int j = 1; j <= n; j++) 
            {
                System.out.printf("%d ", num); 
                
                // Increment Num
                num += inc;                    
            }

            // Reverse direction - Next Row
            inc *= -1;      
            
            /*
                Odd Row : 
                    1 2 3  => num += (n - 1)
                
                Even Row : 
                    6 5 4  => num += (n + 1)
            */    
            num += (n + inc);    
            
            System.out.println(); 
        }
    }
}