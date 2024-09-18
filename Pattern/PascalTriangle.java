package Pattern;

import java.util.Scanner;

/*
 * 
 *	Pascal's Triangle is a triangular array of the binomial coefficients.
 *	It has many important properties and applications in combinatorics, algebra, and geometry.
 */

public class PascalTriangle {

	static void pascal(int n) 
	{
		for(int line=1; line<=n; line++)
		{
			for(int j=line; j<n; j++)
				System.out.print(" ");
			
			int num = 1;
			for(int j=1; j<=line; j++)
			{
				System.out.print(num + " ");
				/*
				 *  C(line,i) = C(line,i) × line−i / i
				 */
				num = num * (line - j)/j;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter : ");
		int n  = s.nextInt();
		
		pascal(n);
		
		s.close();
	}

}
