class Solution {
    // Min Operations to Convert Word_1 into Word_2
    public int minDistance(String word1, String word2) 
    {
        int n = word1.length(), m = word2.length();

        // Dynamic Programming : advance version of LCSSeq
        int[][] dp = new int[n + 1][m + 1];

        /*
            Both word are Empty - 0 operations Req
                dp[0][0] = 0
        */

        /*
            Word1 non-Empty and  Word2 Empty
            "abc" -> "" [ 3 Deletions]

                dp[i][0] = len(word1)
        */
        for(int i = 1; i <= n; i++)
            dp[i][0] = i;

        /*
            Word1 Empty and  Word2 non-Empty
            "" -> "abc" [ 3 Insertions]
            
                dp[0][j] = len(word2)
        */
        for(int j = 1; j <= m; j++)
            dp[0][j] = j;

        // I : Word1    J : Word2
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                /*
                    Char Matches - no Operations required

                    cur DP = prev Opertions without
                                cur Char in both Word
                */
                if(word1.charAt(i-1) == word2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }

                /*
                    char Not Matches - Replace / Delete / Insert

                    REPLACE : Operations from Prev Chars
                        "abc" , "adc"  -> "a_d_c" (i-1, j-1)

                    DELETE : Operations without Word1 char
                        "abc" , "ab" -> "ab_" (i-1, j)

                    INSERT : Opertions without Word2 char,
                                we make Match by insert 
                        "ac" , "abc" -> "a_b_c" (i, j-1)
                */
                else
                {
                    // One for cur Operation + min(R, D, I)
                    dp[i][j] = 1 + (
                                    Math.min( dp[i-1][j-1] ,
                                    Math.min( dp[i-1][j],
                                              dp[i][j-1] ) )
                                    );
                }
            }
        }

        // return Min Operations to Edit
        return dp[n][m];
    }
}