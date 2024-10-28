class Solution {
    public int firstUniqChar(String s) 
    {
        int[] letterCount = new int[26];

        // count the Character in String
        for(char c : s.toCharArray())
        {
            letterCount[c - 'a']++;
        }

        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);

            // Unique - return index
            if(letterCount[c - 'a'] == 1)
                return i;
        }

        // not Unique
        return -1;
    }
}