class Solution {
    public boolean isSubsequence(String s, String t) 
    {
        // x - traverse "S" \ y - traverse "T"
        int x = 0, y = 0;

        // check end of Strings
        while(x < s.length() &&  y < t.length())
        {
            // if matches increment subSeq
            if(s.charAt(x) == t.charAt(y))
                x++;

            // either Match or Not increment T
            y++;
        }

        // x matches length subSeq
        return x == s.length();
    }
}