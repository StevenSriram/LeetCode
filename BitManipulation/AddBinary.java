class Solution {
    public String addBinary(String a, String b) 
    {
        // Integer representation of Two Binary Strings
        int num1 = Integer.parseInt(a, 2);
        int num2 = Integer.parseInt(b, 2);

        /*
            num1 - 101 (5)      num2 - 110 (6)

            num1 => 
                    101
                    110 ^
                    011

            num2 => 
                    101
                    110 &
                    100

                    100 << 1 = 1000

            num1 => 
                    0011
                    1000 ^
                    1011

            num2 => 
                    0011
                    1000 &
                    0000

                    0000 << 1 = 0000
    
            Add = 1011 (11)
        */

        while(num2 != 0)
        {
            // Ex-OR of numbers = adding two number without Carry 
            int withOutCarry = num1 ^ num2;

            // AND of numbers and Left-Shift = adding two number only Carry 
            int onlyCarry = (num1 & num2) << 1;

            num1 = withOutCarry;
            num2 = onlyCarry;
        }

        // binary of Addition of Numbers
        return Integer.toBinaryString(num1);
    }
}