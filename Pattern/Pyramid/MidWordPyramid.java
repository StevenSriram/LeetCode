public class Solution {
	/*
		  	****A 
			***A C 
			**A C T 
			*A C T R 
			A C T R E 
	*/

	public void midWordPyramid(String str) 
	{
		int n = str.length();
		
		// Middle of String
		int mid = str.length() / 2;
		
		// i : 1 to N
		for(int i = 1; i <= n; i++)
		{
			// print Star : 1 to N - I 
			for(int j = 1; j <= n-i; j++)
				System.out.print("*");
			
			// print from Mid Idx
			int idx = mid;
			
			// print Char : 1 to I
			for(int j = 1; j <= i; j++)
			{
				System.out.printf("%c ", str.charAt(idx));
				
				// Middle to Circular
				idx = (idx + 1) % n;
			}
			
			System.out.println();
		}
	}
}
