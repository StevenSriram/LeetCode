class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length();
        int l3 = s3.length();

        // not InterLeaving
        if(l1 + l2 != l3)
            return false;

        // Dynamic Programming Table
        boolean dp[][] = new boolean[l1 + 1][l2+ 1];
        dp[l1][l2] = true;
        
        /*
            s1 : i  \   s2 : j
                s3 : i + j      // length S3 = len S1 + len S2
        */

        // start from End
        for(int i = l1; i >= 0; i--)
        {
            for(int j = l2; j>=0; j--)
            {
                // from till Matches on S1
                if(i < l1 && s1.charAt(i) == s3.charAt(i+j) && dp[i+1][j])
                {
                    dp[i][j] = true;
                }

                // from till Matches on S2
                if(j < l2 && s2.charAt(j) == s3.charAt(i+j) && dp[i][j+1])
                {
                    dp[i][j] = true;
                }
            }
        }
        // InterLeaved String
        return dp[0][0];
    }
}