class Solution {
    public String encode(List<String> strs) 
    {
        // Encode String -> " 8#leetcode4#java" 
        StringBuilder encoded = new StringBuilder();

        for(String str : strs)
        {
            // Append str Length followed by a delimiter '#'
            encoded.append(str.length());
            encoded.append('#');

            // Append the actual string
            encoded.append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) 
    {
        // Decode List -> ["leetcode", "java"]
        List<String> decoded = new ArrayList<>();

        // iterate over String
        int i = 0;
        while(i < str.length())
        {
            // length of cur String (up to the '#')
            int len = 0;
            while(str.charAt(i) != '#')
            {
                len = len * 10 + (str.charAt(i) - '0'); 
                i++;
            }

            // Skip the '#' character
            i++; 

            // Extract String - substring(idx, idx + curLen)
            decoded.add(str.substring(i, i + len));

            // Move to next String
            i += len;
        }

        return decoded;
    }
}

