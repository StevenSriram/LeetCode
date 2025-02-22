class Solution {
    /*  N = 36  and  sqrt(N) = 6

    Divisors of 36 :
    1, 2, 3, 4, 6, 9, 12, 18, 36.

    Pairs of divisors:
    (1, 36), (2, 18), (3, 12), (4, 9), (6, 6).

    Notice that the divisors 2, 3, 4, 6 are all less than or equal to 6,
    and the corresponding paired divisors 18, 12, 9 are all greater than or equal to 6.

    Once we check divisors up to 6, we've already found all the pairs.
    There's no need to check further, because any divisor larger than 6 
    would have been paired with a smaller divisor.
*/
    public boolean isPrime(int num) {
        // 1 - neither Prime nor Composite
        if(num <= 1)    
            return false;
        
        // 2 - Only Even Prime
        if(num == 2)
            return true;
       
        // Number divisible by 2 - Not Prime
        if(num % 2 == 0)
            return false;
        
        // loop from 3 to sqrt(N)
        for(int i=3; i <= ((int) Math.sqrt(num)); i += 2)
        {
            // any factor divide Number - Not Prime
            if(num % i == 0)
                return false;
        }
        
        // Non factor divides - Prime
        return true;
    }
}