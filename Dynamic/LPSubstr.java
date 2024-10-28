class Solution {
    public String longestPalindrome(String s) 
    {
        /* Divide Around Center Algorithm */
        int n = s.length();

        // Max Length and Palindromic Substring
        int maxLen = 0;
        StringBuilder res = new StringBuilder();

        // each char take this as center of Palindrome
        for(int i=0; i<n; i++)    
        {
            /* ODD Palindrome */
                // start form center (i, i)
                int l = i, r = i;

                // check out of Bounds and palindrome
                while(l >= 0 && r < n && s.charAt(l) == s.charAt(r))
                {
                    // find maxLength and update LPS
                    if(r - l + 1 > maxLen)
                    {
                        res.setLength(0);
                        res.append(s.substring(l, r+1));
                        maxLen = r - l + 1;
                    }
                    l--;
                    r++;
                }

            /* EVEN Plaindrome */
                // start form mid range (i, i+1)
                l = i; r = i+1;

                // check out of Bounds and palindrome
                while(l >= 0 && r < n && s.charAt(l) == s.charAt(r))
                {
                    // find maxLength and update LPS
                    if(r - l + 1 > maxLen)
                    {
                        res.setLength(0);
                        res.append(s.substring(l, r+1));
                        maxLen = r - l + 1;
                    }
                    l--;
                    r++;
                }
        }
        // Longest Palindromic Substring
        return res.toString();
    }
}