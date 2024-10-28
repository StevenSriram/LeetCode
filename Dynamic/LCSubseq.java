class Solution {
    public int longestCommonSubsequence(String text1, String text2) 
    {
        int n = text1.length(), m = text2.length();

        // Dynamic Programming : 
        //      i - text1   j - text2            
        int[][] dp = new int[n + 1][m + 1];

        // Fill table
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                /* Character Matched : (1 + dp[i-1][j-1])
                    add cur_Char with previously Matched     
                    SubSequence by Including cur_Char + previous SubSeq
                */
                if(text1.charAt(i-1) == text2.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                /* Not Matched : MAX(dp[i-1][j], dp[i][j-1])
                    maintain Max of previous SubSequence 
                    by Excluding Both char One by One 
                */
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // Printing Longest Common Subsequence
        int i = n, j = m;
        while(i > 0 && j > 0)
        {
            // char Matched add to LCS
            if(text1.charAt(i-1) == text2.charAt(j-1))
            {
                System.out.println(text1.charAt(i-1));
                i--;
                j--;
            }
            // exclude char from Text1 is Greater
            else if(dp[i-1][j] > dp[i][j-1])
            {
                i--;
            }
            // exclude char from Text2 is Greater
            else
            {
                j--;
            }
        }

        // Not Found ? 0 : Longest Common SubSequence
        return dp[n][m];
    }
}