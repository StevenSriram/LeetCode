class Solution {
    public double powHelper(double x, int n) 
    {
        // Any num power 0 is 1
        if (n == 0)  
            return 1.0;

        // Recursively calculate power of x ^ (n/2)
        double half = powHelper(x, n / 2);

        // ODD exponent : multiply result by x once more
        if (n % 2 == 1)
        {
            return x * half * half;
        }

        // EVEN exponent : just square half result
        return half * half;
    }

    public double myPow(double x, int n) 
    {
        // 0 raised to any power is 0
        if (x == 0)  
            return 0.0;

        if (n < 0)    
        {
            x = 1 / x;  // Take reciprocal of x
            n = -n;     // -Ve exponent to +Ve
        }

        /*
            Special case : Integer.MIN_VALUE
    
                int -> ( -2^31 to 2^31 - 1 )

            -(-2^31) = 2^31  : (-N) overflows Integer.MAX_VALUE
        */
        if (n == Integer.MIN_VALUE)
        {
            // Multiply by x one more time * Integer.MAX_VALUE
            return x * powHelper(x, Integer.MAX_VALUE);
        }

        return powHelper(x, n);
    }
}
