class Solution {
    public boolean isAnagram(String s, String t) {
        // different Length
        if(s.length() != t.length())
            return false;

        // count Alphabet Letter - 26
        int[] letterCount = new int[26];

        // increase count
        for(char c : s.toCharArray())
            letterCount[c - 'a']++;

        // decrease count
        for(char c : t.toCharArray())
            letterCount[c - 'a']--;
        
        for(int val : letterCount)
        {
            // not matches Not Anagram
            if(val != 0)
                return false;
        }
        // Anagram
        return true;
    }
}