class Solution {
    // All Combination of size K in N-numbers
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) 
    {
        res = new ArrayList<>();
        
        // Start from 1 - [1, 2, 3 ... n]
        backTrack(1, new ArrayList<>(), n, k);

        return res;
    }

    void backTrack(int start, List<Integer> cur, int n, int k)
    {
        // curComb size equals to K
        if(cur.size() == k)
        {
            // combination Found
            res.add(cur.stream().toList());
            return;
        }

        /* Recursive Tree : 
                                        (1-3) []
                    
                     (2-3) [1]               (2-3) [2]     (3-3)  [3]

            (3-3) [1,2]     (3-3) [1,3]    (3,3) [2,3]         x
        */

        // iterate from curStart to n
        for(int i = start; i <= n; i++)
        {
            // add cur number
            cur.add(i);

            // move to next Number i + 1
            backTrack(i + 1, cur, n, k);

            // BackTrack : remove lastly added number
            cur.remove(cur.size() - 1);
        }
    }
}