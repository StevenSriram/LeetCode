public class Solution {
	public void last_Kbits(int n, int k) 
	{
		// Binary of the number
        System.out.println("\nBinary : " + Integer.toBinaryString(n));
        
        // ? Mask to isolate the last k bits
        int mask = (1 << k) - 1;
        
        /* 
         	12 - 1100	k = 3
         	
         	(1 << k) : 1 left Shift of K times
     			   Create K empty Bits on Last (8-bits)
         			   
		    1      : 00000001
		    1 << K : 00001000
		    
		    
		    -1 	   : 11111111 ( 2's Complement )
		    
		    
		    		00001000
		    		11111111	+
		    		- - - - -
		    Mask = 	00000111
        */
        
        // ? Extract the last k bits using bitwise AND
        int last = n & mask;
        
        /*
          		00001100
          		00000111	&
          		- - - - -
          		00000100 	=> Lask K Bits
        */
        
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(last));
        
        // Padd with Zeroes
        while (sb.length() < k) {
            sb.insert(0, '0');
        }
        
        System.out.println("Last K bits: " + sb);
	}
}
