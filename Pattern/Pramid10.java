package Pattern;

import java.util.Scanner;

public class Pramid10 {
	
	static void pramid_1_0(int n) 
	{
		for(int i=1;i<=n;i++)
		{
			for(int j=i;j<n;j++)
				System.out.print(" ");
			
			for(int j=1;j<=i;j++)
			{
				if((i + j) %2 == 0) 
				{
					System.out.print(1 + " ");
				}
				else
				{
					System.out.print(0 + " ");
				}
			}
			
			System.out.println();
		}
	}

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter : ");
		int n = s.nextInt();
		
		pramid_1_0(n);
		
		s.close();
	}

}
