class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();

        // Arbitrarily(mono) take string 1 as Prefix
        outerLoop:
        for(int i=0; i<strs[0].length(); i++)
        {
            // for each String
            for(String s : strs)
            {
                // prefix Not Matched or size Exceeds
                if(i >= s.length() || s.charAt(i) != strs[0].charAt(i))
                    break outerLoop;
            }
            // add to Prefix
            res.append(strs[0].charAt(i));
        }
        
        // Longest Common Prefix
        return res.toString();
    }
}