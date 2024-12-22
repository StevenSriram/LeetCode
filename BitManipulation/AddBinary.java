class Solution {
    public String addBinary(String a, String b) 
    {
        // Index of String A,B
        int i = a.length() - 1;
        int j =  b.length() - 1;

        // result - Added Binary 
        StringBuilder sb = new StringBuilder();

        // carry of each Bit
        int carry = 0;

        // A, B char Exists OR carry Exits
        while(i >= 0 || j >= 0 || carry > 0)
        {
            // add sum to previous Carry
            int sum = carry;

            // char Exits in A String - add
            if(i >= 0)
                sum += a.charAt(i) - '0';

            // char Exits in B String - add
            if(j >= 0)
                sum += b.charAt(j) - '0';

            // Carry = Remaing After Last Bit [sum / 2]
            carry = sum / 2;

            // Insert Last Bit [sum % 2]
            sb.insert(0, sum % 2);

            // move Bits
            i--;
            j--;
        }

        return sb.toString();
    }
}