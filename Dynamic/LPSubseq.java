class Solution {
    public int longestPalindromeSubseq(String s) 
    {
        // LongestPalindromeSubseq == LongestCommonSubsequence(str, reverse str)
        return longestCommonSubsequence(
                    s,
                    new StringBuilder(s).reverse().toString()
        );
    }

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
        
        // Not Found ? 0 : Longest Common SubSequence
        return dp[n][m];
    }
}
