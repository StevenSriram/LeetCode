class Solution {
    public int[] computeLPS(String pattern)
    {
        int m = pattern.length();

        /* LPS (Longest Prefix that is also a Suffix) */
        int[] lps = new int[m];

        // prevLPS length (LPS of start always 0), cur LPS (1)
        int prevLPSLen = 0, cur = 1;

        while(cur < m) 
        {
            // Both Characters matches
            if(pattern.charAt(prevLPSLen) == pattern.charAt(cur)) 
            {
                // Extend matching prefix-suffix length
                lps[cur] = prevLPSLen + 1; 

                prevLPSLen++;
                cur++;
            }
            else 
            {
                // No match found
                if(prevLPSLen == 0) 
                {
                    // Set cur to 0
                    lps[cur] = 0; 
                    cur++;
                }
                else 
                {
                    // check lps[prevLPSLen - 1] matches
                    prevLPSLen = lps[prevLPSLen - 1]; 
                }
            }
        }

        return lps;
    }

    public int strStr(String str, String pattern) 
    {
        int n = str.length(), m = pattern.length();

        int[] lps = computeLPS(pattern);

        /* KMP algorithm to find Pattern in String */
        int i = 0, j = 0; 
        
        // iterate over -> Str
        while(i < n) 
        {
            // Characters match, move both Pointers
            if(str.charAt(i) == pattern.charAt(j)) 
            {
                i++;
                j++; 
            } 
            else 
            {
                // No match and j is at start, move i
                if(j == 0) 
                {
                    i++; 
                } 
                else 
                {
                    // Use LPS to avoid rechecking
                    j = lps[j - 1]; 
                }
            }

            // Full pattern Matches (j -> reached End)
            if(j == m)
            {
                // Index of First Occurance
                return i - j;
            }
        }

        // Pattern not Found
        return -1;
    }
}
/* Time Complexity: O(n + m)
   Space Complexity: O(m) for LPS array */