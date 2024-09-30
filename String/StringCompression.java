class Solution {
    public int compress(char[] chars) {
        // index of Compressed String
        int idx = 0;

        // run Length Encoding
        int run = 1;
        for(int i=1; i<chars.length; i++)
        {
            // Same characters increase Run Length
            if(chars[i] == chars[i-1])
            {
                run++;
            }
            // add Character + Run Length
            else
            {
                chars[idx++] = chars[i-1];
                if(run > 1)
                {
                    // for two digit Length
                    for(char c : String.valueOf(run).toCharArray())
                        chars[idx++] = c;
                }
                // reset run length
                run = 1;
            }
        }
        // handle last Character
        chars[idx++] = chars[chars.length-1];
        if(run > 1)
        {
            for(char c : String.valueOf(run).toCharArray())
                chars[idx++] = c;
        }

        // length of run length Encoding String
        return idx;
    }
}