class Solution {
	public int longestCommonSubstring(String text1, String text2)  
	{
		int n = text1.length(), m = text2.length();
		
		// Max length of Substring
		int maxLen = Integer.MIN_VALUE;
		// Ending Index of Substring
		int endIdx = -1;
		
		// Dynamic Programming : 
		//	i - text1	  j - text2
		int[][] dp = new int[n + 1][m + 1];
		
		// Fill Table
		for(int i = 1; i <= n; i++)
		{
			for(int j = 1; j <= m; j++)
			{
				/*  Character Matched : (1 + dp[i-1][j-1])
	                    add cur_Char with previously Matched     
	                    SubString by Including cur_Char + previous Substring
				*/
				if(text1.charAt(i-1) == text2.charAt(j-1))
				{
					dp[i][j] = 1 + dp[i-1][j-1];
					
					// find maxLength and endIndex
					if(dp[i][j] > maxLen)
					{
						maxLen = dp[i][j];
						endIdx = i;
					}
				}
				
				/* Not Matched : don't carry - Substring { dp[i][j] = 0 } */
			}
		}
		
		// Printing Longest Common Subsequence 
		/* .substring() - Index based not length based (endIdx - maxLen, endIdx) */
		System.out.println(text1.substring(endIdx - maxLen, endIdx));
		
		// Not Found ? 0 : Longest Common Substring
		return (maxLen == Integer.MIN_VALUE)? 0 : maxLen;
	}
}
