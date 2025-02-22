class Solution {
    public boolean isUgly(int num) 
    {
        /* 
            Ugly number is a + Ve integer which 
            does not have a prime factor other than 2, 3, and 5.
        */
        if(num <= 0)
            return false;

        // List of all Prime factors
        List<Integer> primeFactors = new ArrayList<>(Arrays.asList(2, 3, 5));

        /*
        Prime Factorization : 
            Any positive integer greater than 1 can be 
                expressed as a product of prime factors
        */

        // take each factor
        for(int factor : primeFactors)
        {
            // do repetitive Division by 2, 3, 5
            while(num % factor == 0)
                num /= factor;
        }

        // Ugly - Completely divided
        return num == 1;
    }
}