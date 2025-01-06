public class Solution {
	public void toggleLast_K(int n, int k) 
	{
		// Actual  Number and Its Binary
		System.out.printf("%d - %s\n", n, Integer.toBinaryString(n));		
		
		// Mask - create a K bits with 1
			// last 3 Bits - 111 (7)
		int mask = (int) Math.pow(2, k) - 1;
		
		
		// Toggle with Ex - OR 
		int toggled = n ^ mask;
		
		/*
		 	1 ^ 1 - 0
		 	0 ^ 1 - 1
		 	
		 	1 ^ 0 - 1
		 	0 ^ 0 - 0
		*/
		
		// Toggled Number and Its Binary
		System.out.printf("%d - %s", toggled, Integer.toBinaryString(toggled));
	}

}
