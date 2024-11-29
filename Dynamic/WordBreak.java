class Solution {
    // Dynamic Programming : Bottom Up

    public boolean wordBreak(String s, List<String> wordDict) 
    {
        // length of String
        int n = s.length();

        // dp for cache size of S + 1
        boolean[] dp = new boolean[n + 1];

        // Dp last index - true
        dp[n] = true;

        // start from last word in String
        for(int i = n - 1; i >= 0; i--)
        {
            // take each word from wordDict
            for(String word : wordDict)
            {
                // length of each Word
                int len = word.length();

                /*
                    check Inbounds :
                         curIdx + size of word <= size of S

                    check subString Matches : 
                        S.subString(curIdx, curIdx + size of word) == word
                */
                if(i + len <= n && s.substring(i, i + len).equals(word))
                {
                    // update Word Break [i + len]
                    dp[i] = dp[i + len];
                }

                // Word Break found - break loop
                if(dp[i])   break;
            }
        }

        // return Word Break from First Index
        return dp[0];
    }
}