class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length(), m = word2.length();

        // Aternately Merged String
        StringBuilder sb = new StringBuilder();

        // add char alternately till minLength
        int i = 0;
        while(i < n && i < m)
        {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));

            i++;
        }

        // add remaining char in Word1
        if(i < n)
        {
            sb.append(word1.substring(i));
        }
        // add remaining char in Word2
        if(i < m)
        {
            sb.append(word2.substring(i));
        }

        return sb.toString();
    }
}