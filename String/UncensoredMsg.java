public class Solution
{
    public String void uncensoredMessage(String s)
    {
        // Turn Message into Character Array
        char[] message = s.toCharArray();
        
        // Start of Word
        int i = 0;
        while(i < message.length)	    
        {
            int j = i + 1;
            
            // Find the next Space or End of String
            while(j < message.length && message[j] != ' ')
                j++;
            
            // Word Length greater than 5
            if(j - i > 5)
            {
                // Censor the word with *
                for(int c = i; c < j; c++)
                    message[c] = '*';
            }
            
            // move to Next Word after Space, End
            i = j + 1;
        }
        
        return new String(message);
    }
}
