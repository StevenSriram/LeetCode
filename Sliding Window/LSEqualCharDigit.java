public class Solution
{
    public int longestEqualCharAndDigit(String s)
    {
        // Maps -> curBalance : startPos of subString
        Map<Integer, Integer> startPos = new HashMap<>();
        
        // maxLen of subString having Equal Chars and Digits
        int maxLen = 0;
        
        // Char : +1    Digit : -1
        int balance = 0;
        
        /* 
            curBalance(0) : startPos(-1) 
              0 - based Index 
            
            whenEver we find curBalance again 
                maxLen  =  curPos - startPos of curBalance
        */
        startPos.put(balance, -1);
        
        // Iterate String
        for(int r = 0; r < s.length(); r++)
        {
            char ch = s.charAt(r);
            
            // char is Alphabet : +balance
            if(Character.isAlphabetic(ch))   
                balance++;
            
            // char is Digit : -balance
            else
                balance--;
                
            // balance already contains in Map
            if(startPos.containsKey(balance))
            {
                // take Start of String
                int l = startPos.get(balance);
                
                // curPos - startPos
                maxLen = Math.max(maxLen, r - l);
            }
            
            // balance doesn't contains
            else
            {
                // add this Start Pos of new subString
                startPos.put(balance, r);
            }
        }
        
        return maxLen;
    }    
}