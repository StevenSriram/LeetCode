class Solution {
    public int longestValidParentheses(String s) 
    {
        int n = s.length();  

        // Longest Valid Parentheses
        int maxLen = 0;  

        // Open : '('   Close : ')'
        int open = 0, close = 0;

        // First pass: Left - Right to capture Extra ')'
        for(int i = 0; i < n; i++)    
        {
            char ch = s.charAt(i);  

            // Count open, close parentheses
            if(ch == '(')
                open++;  
            else if(ch == ')')
                close++;  

            // Open equal to Close - Valid Parentheses
            if(open == close)
            {
                // curLen = 2 * Close 
                maxLen = Math.max(maxLen, 2 * close);  
            }

            // if Extra Close, reset counters
            else if(close > open)
            {
                open = close = 0; 
            }
        }

        open = close = 0;

        // Second pass: Right - Left to capture Extra '('
        for(int i = n - 1; i >= 0; i--)    
        {
            char ch = s.charAt(i);  

            // Count open, close parentheses
            if(ch == '(')
                open++;  
            else if(ch == ')')
                close++;  

            // Open equal to Close - Valid Parentheses
            if(open == close)
            {
                // curLen = 2 * Close 
                maxLen = Math.max(maxLen, 2 * open);  
            }

            // if Extra Open, reset counters
            else if(open > close)
            {
                open = close = 0;  
            }
        }

        return maxLen;  
    }
}
