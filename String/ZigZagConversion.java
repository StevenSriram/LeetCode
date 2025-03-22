class Solution {
    public String convert(String s, int numRows) 
    {
        int n = s.length();

        // no. Rows 1 - return Same String
        if(numRows == 1)    
            return s;
        
        StringBuilder sb = new StringBuilder();

        /*
            Increment : 
                            \   / *2
               (numRows - 1) \ /    
        */
        int inc = (numRows - 1) * 2;

        // for each Row
        for(int r = 0; r < numRows; r++)
        {
            // from r to N  (i += inc)
            for(int i = r; i < n; i += inc)
            {
                // add Char to res
                sb.append(s.charAt(i));

                /*  
                    missed Mid of ZigZag : 

                        idx + Increment - 2 * Row

                    we measuring Size of V 
                        - as go deeper V size decreases
                */
                int midIdx = i + inc - 2 * r;

                // do only for mid Rows - inbounds
                if(r > 0 && r < numRows - 1 && midIdx < n)
                {
                    // add missed Mid to res
                    sb.append(s.charAt(midIdx));
                }
            }
        }

        return sb.toString();
    }
}