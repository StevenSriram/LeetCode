class Solution {
    public int euclideanGCD(int a, int b)
    {
        /*
            Two Numbers - A and B

            when a divided by b,

                [ A = B * Q + R ]
            
            Q - Quotient    R - remainder

            while R not equals ZERO
                 assign A = B  and  B = R
            
            return A (Greatest Common Divisor)
        */

        // remainder != 0
        while(b != 0)
        {
            int temp = b;

            // assign remainder to B
            b = a % b;

            // assign B to A
            a = temp;
        }

        // return last Non ZERO remainder
        return a;
    }

    public int minOperations(int[] nums, int[] numsDivide) 
    {
        int gcdDivide = numsDivide[0];

        // GCD of numsDivide Array
        for(int i=1; i<numsDivide.length; i++)    
        {
            gcdDivide = euclideanGCD(gcdDivide, numsDivide[i]);
        }

        // minimum Deletion Required
        int minDelete = 0;

        // Sort the nums
        Arrays.sort(nums);

        for(int n : nums)
        {
            /*
                If num Divides (or Factor of) Gcd of numsDivide, that means 
                    it divides all the element in numsDivide

                because GCD divides all element of numsDivide
            */
            if(gcdDivide % n == 0)
            {
                // Smallest element divides All numsDivide
                return minDelete;
            }
            
            // delete this element
            minDelete++;
        }

        return -1;
    }
}