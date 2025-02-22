class Solution {
    List<Integer> primeRange(int M, int N) 
    {
        /* Seive Of Eratosthenes - Prime Algorithm */
        
        // Array to track Primes Status
        boolean[] primes = new boolean[N + 1];

        // intially assume all are Primes
        Arrays.fill(primes, true);
        
        // 0 and 1 are not Primes
        primes[0] = primes[1] = false;
        
        // start from 2 and check all Factors till sqrt(N)
        for(int factor = 2; factor <= Math.sqrt(N); factor++)
        {
            // if factor is Prime
            if(primes[factor])
            {
                // mark all its Multiples as not Prime
                for(int multiple = factor * factor; multiple < N + 1; 
                                        multiple += factor)
                {
                    primes[multiple] = false;
                }
            }
        }
        
        // store Primes between M and N
        List<Integer> res = new ArrayList<>();
        
        for(int num = M; num <= N; num++)
        {
            // if num is Prime
            if(primes[num])
                res.add(num);
        }
        
        return res;
    }
}