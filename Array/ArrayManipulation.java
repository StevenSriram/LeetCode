class Solution{
    /*
        N = 10

         A  B  K
        [1, 5, 3]
        [4, 8, 7]
        [6, 9, 1]

         1  2  3  4  5  6  7  8  9  10
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        [3, 0, 0, 0, -3, 0, 0, 0, 0, 0] 
        [3, 0, 0, 7, -3, 0, 0, -7, 0, 0] 
        [3, 0, 0, 7, -3, 1, 0, -7, -1, 0]

        { 3, 3, 3, 10, 7, 8, 8, 1, 0, 0 }     MAX : 10
    */
     public long arrayManipulation(int n, List<List<Integer>> queries) {
        
        long max = Long.MIN_VALUE;

        // Array to Manipulate
        long[] res = new long[n+1];
        Arrays.fill(res, 0);
        
        // take Queries
        for(List<Integer> q : queries)
        {
            int start = q.get(0);
            int end = q.get(1);
            int k = q.get(2);
            
            // add 'K' to Start
            res[start - 1] += k;

            // sub 'K' from end
            if(end <= n)
                res[end] -= k;
        }
        
        // Cummulative Sum on manipulated Array
        for(int i=1; i<n; i++)
        {
            res[i] += res[i-1];
            max = Math.max(max, res[i]);
        }

        // return maxSum
        return max;
    }
}