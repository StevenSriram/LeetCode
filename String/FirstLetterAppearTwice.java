class Solution {
    public char repeatedCharacter(String s) 
    {
        // for check Character Exists
        boolean[] letters = new boolean[26];

        for(char c : s.toCharArray())
        {
            // already Visited - return 
            if(letters[c - 'a'])
                return c;
            
            // mark Visited
            letters[c - 'a'] = true;
        }
        return '\0';
    }
}