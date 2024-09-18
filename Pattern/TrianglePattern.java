package Pattern;

import java.util.Scanner;

public class TrianglePattern {

	static void rightTriangle(int n) 
	{
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
				System.out.print("*");
			
			System.out.println();
		}
	}
	
	static void reverseRightTriangle(int n) 
	{
		for(int i=n;i>=1;i--)
		{
			for(int j=1;j<=i;j++)
				System.out.print("*");
			
			System.out.println();
		}
	}
	
	static void leftTriangle(int n)
	{
		for(int i=n;i>=1;i--)
		{
			for(int j=1;j<i;j++)
				System.out.print(" ");
			
			for(int j=0;j<=n-i;j++)
				System.out.print("*");
			
			System.out.println();
		}
	}
	
	static void reverseLeftTriangle(int n)
	{
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<i;j++)
				System.out.print(" ");
			
			for(int j=1;j<=n-i+1;j++)
				System.out.print("*");
			
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter : ");
		int n  = s.nextInt();
		
		rightTriangle(n);
		
		reverseRightTriangle(n);
		
		leftTriangle(n);
		
		reverseLeftTriangle(n);
		
		s.close();
	}

}
