class Solution {
    // Pascal's Triangle is a triangular array of the binomial coefficients.

    public List<List<Integer>> generate(int numRows) 
    {
        List<List<Integer>> res = new ArrayList<>();

        // n times - Pascal's triangles row
        for(int i=1; i<=numRows; i++)
        {
            // generate each Row add to result
            res.add( generateRow(i) );
        }

        return res;
    }

    public List<Integer> generateRow(int n)
    {
        // cur Row Values
        List<Integer> cur = new ArrayList<>();
        // add 1 to Start
        cur.add(1);

        // start from 0 indexed Array
        int ans = 1;
        for(int i=1; i<n; i++)
        {
            /*
                n = 5

                4/1 = 4, 4x3/1x2 = 6, 4x3x2/1x2x3 = 4, 4x3x2x1/1x2x3x4 = 1
                CurRow : [1, 4, 6, 4, 1]
            */
            ans *= (n - i);
            ans /= (i);

            // add ans to curRow value
            cur.add(ans);
        }
        return cur;
    }
}