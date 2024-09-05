class Solution {
    public boolean isPalindrome(String s) {
        // empty String
        if(s.isEmpty())
            return true;
        
        // Left - Right Pointer
        int l = 0, r = s.length() - 1;
        while(l <= r)
        {
            char curL = s.charAt(l);
            char curR = s.charAt(r);

            // omit Non - LetterDigit
            if(!Character.isLetterOrDigit(curL))
            {
                l++;
            }
            else if(!Character.isLetterOrDigit(curR))
            {
                r--;
            }
            else
            {
                // differ Not Palindrome
                if(Character.toLowerCase(curL) != Character.toLowerCase(curR))
                    return false;
            
                l++;
                r--;
            }
        }
        // Palindrome
        return true;
    }
}