class Solution {
    public int reverse(int num) 
    {
        // Reverse of Number
        int rev = 0;
        
        // Remainder of Number
        int rem = 0;

        // Num not equals to 0
        while(num != 0)
        {
            // take last digit
            rem = num % 10;

            /*
                MAX_VALUE : 2^31 - 1
                MIN_VALUE : -2^31

                Num greater than 2^30 or -2^30 : OverFlow Integer Range
            */
            if(rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10)
                return 0;
            
            /*
                Reverse = Reverse * 10 + Remainder

                multiply prev Rev with 10 and add Rem 
                    - to make way for One's Place
            */
            rev = rev * 10 + rem;

            // remove last digit
            num /= 10;
        }

        return rev;
    }
}