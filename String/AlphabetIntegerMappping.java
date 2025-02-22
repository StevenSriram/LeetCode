class Solution {
    public String freqAlphabets(String s) 
    {
        // StringBuilder to Store Alphabet Mapping
        StringBuilder sb = new StringBuilder();

        // iterate from End
        for(int i = s.length() - 1; i >= 0; i--)
        {
            // take Number from String
            int number;

            // char is '#'
            if(s.charAt(i) == '#')
            {
                // take Prev Two Char and turn then into Number
                number = (s.charAt(i-2) - '0') * 10 + (s.charAt(i-1) - '0');

                // move to next char
                i -= 2;
            }

            // char is Not '#'
            else
            {
                // turn Char into Number
                number = s.charAt(i) - '0';
            }

            // append Char Mapping -> Value
            sb.append((char) (number + 'a' - 1));
        }

        // reverse the Alphabet Mapping
        return sb.reverse().toString();
    }
}