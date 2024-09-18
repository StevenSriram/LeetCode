package Pattern;

import java.util.Scanner;

public class PalindromeTriangle {
	
	static void palindrome(int n)
	{
		for(int i=1; i<=n; i++)
		{
			for(int j=i; j<n; j++)
				System.out.print("  ");
			
			for(int j=1; j<=i; j++)
				System.out.print(j + " ");
			
			for(int j=i-1; j>=1; j--)
				System.out.print(j + " ");
			
			System.out.println();
		}
	}

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter : ");
		int n  = s.nextInt();
		
		palindrome(n);
		
		s.close();
	}

}
