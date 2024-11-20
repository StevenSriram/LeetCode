class Solution {
    public String reverseWords(String s) 
    {
        int n = s.length();

        // Reversed Each Word in String
        StringBuilder sb = new StringBuilder();

        // Iterate through String
        int i = 0;
        while(i < n)
        {   
            // J : next char to I
            int j = i + 1;

            // move until find WhiteSpace
            while(j < n && s.charAt(j) != ' ')
                j++;
            
            // Add reversed Char to Res
            for(int k = j-1; k >= i; k--)
                sb.append(s.charAt(k));
            
            // Don't add Space to End of res
            if(j < n)
                sb.append(' ');
            
            // I : next to WhiteSpace
            i = j + 1;
        }

        // return Reversed Each Word in String
        return sb.toString();
    }
}