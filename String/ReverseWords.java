class Solution {
    public String reverseWords(String s) 
    {
        int n = s.length();

        // Reversed Words in String
        StringBuilder res = new StringBuilder();

        // Start from 0 - index and go until reach End
        int i = 0;
        while(i < n)
        {
            // skip unWanted whiteSpaces
            while(i < n && s.charAt(i) == ' ')
                i++;
            
            // full string is whiteSpace - BREAK
            if(i == n)  break;

            // j - start from next Char of i
            int j = i + 1;
            // move until single whiteSpace is found
            while(j < n && s.charAt(j) != ' ')
                j++;

            // if result is Empty add Substring itself
            if(res.isEmpty())
                res.append(s.substring(i, j));
            // add Substring + " " to begining
            else
                res.insert(0, s.substring(i, j) + " ");
            
            // set i to next char after whiteSpace
            i = j + 1;
        }
        // return reversed Words String
        return res.toString();
    }
}