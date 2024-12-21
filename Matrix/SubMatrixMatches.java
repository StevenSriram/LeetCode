public class Solution {
	public boolean subMatrixMatched(int[][] big, int[][] small) 
	{
		int n = big.length;	  	// Big - {N * N}
		int m = small.length;	// Small - {M * M}
		
		/*
		 	1 2 3	N = 3
		 	4 5 6	M = 2
		 	7 8 9  	N - M => 3 - 2 = ' 1 '
		 	
		 	{0, 1} only two Pairs of size M exits in N
		*/
		
		// [ N - M ] : SubMatrix of size of M present in N
		for(int i = 0; i <= n - m; i++)
		{
			for(int j = 0; j <= n - m; j++)
			{
				// check for Matrix Matches
				if(isMatch(big, i, j, small, m))
					return true;
			}
		}
		
		// Not Matched
		return false;
	}

	public boolean isMatch(int[][] big, int rowStart, int colStart, int[][] small, int m) 
	{
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < m; j++)
			{
				// Big[row][col] -! Not Equal !- Small[i][j]
				if( big[i + rowStart][j + colStart] != small[i][j] )
					return false;
			}
		}
		// M is subMatrix of N
		return true;
	}
}
