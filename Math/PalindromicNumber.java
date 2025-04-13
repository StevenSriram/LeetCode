class Solution {
    public boolean isPalindrome(int x) 
    {
        // -Ve Num are not Palindromes
        if(x < 0)    
            return false;

        // Reverse of Num
        int rev = 0;      
        int temp = x;     

        // Temp not equals to 0
        while(temp != 0)
        {
            // Add the last digit to rev
            rev = rev * 10 + (temp % 10);  

            // Remove the last digit from temp
            temp /= 10;                    
        }

        // Reverse equals to Num
        return x == rev;
    }
}
