class Solution {
    public int countSubstrings(String s) 
    {
        int n = s.length();

        // Count Of Palindromic Substrings
        int paliLen = 0;

        // Divide Around Center
        for(int i = 0; i < n; i++)
        {
            /* ODD Palindromes */
                // start form center (i, i)
                int l = i, r = i;
                // inBounds and char Matched
                while(l >= 0 && r < n && s.charAt(l) == s.charAt(r))
                {
                    // palindrome Found
                    paliLen++;

                    l--;
                    r++;
                }

            /* EVEN Palindromes */
                // start form mid range (i, i+1)
                l = i; r = i + 1;
                // inBounds and char Matched
                while(l >= 0 && r < n && s.charAt(l) == s.charAt(r))
                {
                    // palindrome Found
                    paliLen++;

                    l--;
                    r++;
                }
        }

        return paliLen;
    }
}