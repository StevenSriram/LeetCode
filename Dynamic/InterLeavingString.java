class Solution {
    public boolean isInterleave(String s1, String s2, String s3) 
    {
        int n = s1.length(), m = s2.length();

        // Length of Interleaved Strings doesn't matches
        if(n + m != s3.length())
            return false;

        //  extra Space at End for handling OutOfBound Case
        boolean[][] dp = new boolean[n + 1][m + 1];

        // both String reaches OutOfBounds - InterLeaved
        dp[n][m] = true;

        /*
            i - Str1    
                        => ( i + j ) - Str3
            j - Str2 
        */

        // Bottom Up - Dynamic Programming Table : 
        for(int i = n; i >= 0; i--)        
        {
            for(int j = m; j >=0 ; j--)
            {
                /*
                    i in Bounds
                    char(i) of str1 matches str3(i+j)
                    check char AFTER this as interleaved
                */
                if(i < n && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j])
                    dp[i][j] = dp[i + 1][j];

                 /*
                    j in Bounds
                    char(j) of str1 matches str3(i+j)
                    check char AFTER this as interleaved
                */
                if(j < m && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1])
                    dp[i][j] = dp[i][j + 1];
            }
        }

        // return all string are Interleaved
        return dp[0][0];
    }
}
