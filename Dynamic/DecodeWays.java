class Solution {
    public int numDecodings(String s) 
    {
        int n = s.length();

        // can't Decode " 0 "
        if(n == 0 || s.charAt(0) == '0')
            return 0;

        // Dynamic Programming
        int[] dp = new int[n + 1];

        // One way to decode an empty string.
        dp[n] = 1;

        // Start from Last Character
        for(int i = n-1; i >= 0; i--)
        {
            // Char is Zero - can't Decode
            if(s.charAt(i) == '0')
            {
                // DP[i] = 0 (No Ways)
                dp[i] = 0;
            }

            // One Way to Decode
            else
            {
                // DP[i] = DP[i + 1]
                //     - decode as Single Digit
                dp[i] = dp[i + 1];
            }

            // check for - two Digit exists
            if(i + 1 < n)
            {
                // Turn into Number : Substring(i, i + 2)
                int num = Integer.parseInt(s.substring(i ,i + 2));

                // valid Two Digit Number
                if(num >= 10 && num <= 26)
                {
                    //  - decode as Two Digit
                    dp[i] += dp[i + 2];
                }
            }
        }
        
        // No. ways to Decode String
        return dp[0];
    }
}