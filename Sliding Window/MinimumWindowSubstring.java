class Solution {
    public String minWindow(String s, String t) 
    {
        // Minimum length of substring in S contains all char in T
        int minWindow = Integer.MAX_VALUE;
        // start of Minimum Window
        int start = -1;

        // hash Table to count Each hash
        int[] hash = new int[256];

        // pre-Insert count of character in String T
        for(char c : t.toCharArray())
        {
            hash[c]++;
        }

        // to find the Window that matches Count of String T
        int countMatch = 0;

        /* Increment right - find the window that matches substring,
           Shrink left - find the window that is less curWindow  */
        int l = 0;
        for(int r = 0; r < s.length(); r++)
        {
            // already per-Inserted in table -> countMatches
            if(hash[s.charAt(r)] > 0)
            {
                countMatch++;
            }
            // reduce char Count in table
            hash[s.charAt(r)]--;

            // window Found
            while(countMatch == t.length())
            {
                // try to find any window less than this
                if(r - l + 1 < minWindow)
                {
                    minWindow = r - l + 1;
                    start = l;
                }

                // Increment left and shrink window to find Minimum Window
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0)
                {
                    // Invalid Window - continue right
                    countMatch--;
                }
                l++;
            }
        }

        // start never updated no SubString : SubString(start, minWindow)
        return start == -1 ? "" : s.substring(start, start + minWindow);
    }
}