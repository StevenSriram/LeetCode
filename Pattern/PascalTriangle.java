import java.util.Arrays;
import java.util.Scanner;

/*
 *	Pascal's Triangle is a triangular array of the binomial coefficients.
 *	It has many important properties and applications in combinatorics, algebra, and geometry.
*/

public class PascalTriangle {

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		// generate particular row , col
//		System.out.print("Enter Row & Col : ");
//		int n = s.nextInt(), r = s.nextInt();
//		System.out.println(nCr(n-1, r-1));
		
		
		// generate full row
//		System.out.print("Enter Nth Row : ");
//		int n  = s.nextInt();
//		System.out.println(pascalRow(n));
		
		// generate Pascal Triangle
		System.out.print("Enter Rows : ");
		int n  = s.nextInt();
		printPascal(n);
		
		
		s.close();
	}
	
	public static void printPascal(int n) 
	{
		for(int i=1; i<=n; i++)
			System.out.println(pascalRow(i));
	}

	public static long nCr(int n, int r) 
	{
		/*
		 	r-1 C c-1 = value of Pascal triangle at Specific Index
		 	
		 	nCr = n! / r! * (n-r)!
		 	
		 	7C2 = 7x6 / 1x2 => (n-r)! cancel out
		*/
		long ans = 1;
		for(int i=0; i<r; i++)
		{
			ans *= (n - i);
			ans /= (i + 1); 
		}
		return ans;
	}

	public static String pascalRow(int n) 
	{
		int[] arr = new int[n];
		arr[0] = 1;
		
		int ans = 1;
		for(int i=1; i<n; i++)
		{
			ans *= (n-i);
			ans /= i;
			arr[i] = ans;
		}
		
		return Arrays.toString(arr);
	}
	
}
