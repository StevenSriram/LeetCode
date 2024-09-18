package Pattern;

import java.util.Scanner;

public class PramidPattern {
	
	static void pramid(int n)
	{
		for(int i=1;i<=n;i++) 
		{
			for(int j=i;j<n;j++)
				System.out.print(" ");
			
			for(int j=1; j <= (2*i-1); j++)
				System.out.print("*");
			
			System.out.println();
		}
	}
	
	static void reversePramid(int n)
	{
		for(int i=n;i>=1;i--)
		{
			for(int j=n;j>i;j--)
				System.out.print(" ");
			
			for(int j=1; j <= (2*i-1); j++)
				System.out.print("*");
			
			System.out.println();
		}
	}
	
	static void hollowPramid(int n)
	{
		for(int i=1;i<=n;i++)
		{
			for(int j=i; j<n; j++)
				System.out.print(" ");
			
			for(int j=1; j <= (2*i-1); j++)
			{
				if(j == 1 || j == (2*i-1) || i == n)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			
			System.out.println();
		}
	}
	
	static void hollowReversePramid(int n)
	{
		for(int i=n;i>=1;i--)
		{
			for(int j=n; j>i; j--)
				System.out.print(" ");
			
			for(int j=1; j <= (2*i-1); j++)
			{
				if(j == 1 || j == (2*i-1) || i == 1 || i == n)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter : ");
		int n  = s.nextInt();
		
		pramid(n);
		
		reversePramid(n);
		
		hollowPramid(n);
		
		hollowReversePramid(n);
		
		s.close();
	}

}
