public class Solution  {
    public void absSumLessThan_K(int n, int k) 
    {
    	// No from {1, 2, 3 ... N}
       int L = 1, R = n;
       
       // Two Pointers - Not Cross Over
       while(L <= R)
       {
    	   // calculate Sum
    	   int sum = L + R;
    	   
    	   // Increase target Sum 
    	   if(sum < n)
    		   L++;
    	   
    	   // Decrease target Sum
    	   else if(sum > n)
    		   R--;
    	   
    	   // targets Found
    	   else
    	   {
    		   // Absolute Difference <= K
    		   if(Math.abs(L - R) <= k)
    		   {
    			   System.out.printf("\n( %d, %d )", L, R);
    		   }
    		   
    		   // Move Pointers
    		   L++;
    		   R--;
    	   }
       }
    }
}
