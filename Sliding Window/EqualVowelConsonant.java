public class Solution {
    public int equalCountVowelsConsonants(String s) {
        // Fixed Size Sliding Window (N)
        int n = s.length();

        // Vowels++     Consonants--
        int balance = 0;
        
        // Equal Vowels and Consonants
        int count = 0;

        // Initial Window N
        for (int i = 0; i < n; i++) {
            // Vowel : balance++
            if(isVowel(s.charAt(i))) 
                balance++;

            // Consonant : balance--
            else 
                balance--;
        }

        // balance (0) : Vowels == Consonants
        if (balance == 0) 
            count++;

        // Slide the Window
        for (int i = n; i < s.length(); i++) {
            // remove the first Char
            balance += isVowel(s.charAt(i - N)) ? 1 : -1;

            // add the next Char
           if(isVowel(s.charAt(i))) 
                balance++;
            else 
                balance--;

            if (balance == 0) 
                count++;
        }

        return count;
    }

    public boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}